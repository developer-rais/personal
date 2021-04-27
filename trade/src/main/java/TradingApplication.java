import com.trading.model.Trade;
import com.trading.services.ClientService;
import com.trading.services.FsmConsumer;
import com.trading.services.TradesProducer;

import java.io.*;
import java.util.*;

public class TradingApplication {

    private static String tradesJsonFilePath;
    private static String clientsFilePath;


    public static void main(String args[]) {
        System.out.println("Trading started....");

       if (args.length > 0) {
            tradesJsonFilePath = args[0];
        } else {
            tradesJsonFilePath = new File("classes/trades.json").getAbsolutePath();
        }

        if (args.length > 1) {
            clientsFilePath = args[1];
        } else {
            clientsFilePath = new File("classes/clients.txt").getAbsolutePath();
        }


        // synchronized collections to manage trades
        Vector<Trade> tradesQueue = new Vector<>();

        // Producer thread
        TradesProducer tradesProducer = new TradesProducer(tradesJsonFilePath, tradesQueue);
        tradesProducer.start(); // (worker 1)

        // clients
        List<ClientService> clientServiceList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(clientsFilePath))) {
            String clientDetails = "";
            while ((clientDetails = br.readLine()) != null) {
                String[] details = clientDetails.split(",");
                if (details.length < 2) {
                    throw new Exception("Wrong input in clients file");
                }
               // System.out.println("adding new client "+ details[0]+" , "+details[1]);
                clientServiceList.add(new ClientService(Long.parseLong(details[0]), details[1]));
            }
        } catch (FileNotFoundException exception) {
            System.out.println("FileNotFoundException exception occurred for clients file. Exception is " + exception);
            System.exit(0);
        } catch (IOException exception) {
            System.out.println("IOException exception occurred for clients file. Exception is " + exception);
            System.exit(0);
        } catch (Exception exception) {
            System.out.println("Exception exception occurred while reading clients file. Exception is " + exception);
            System.exit(0);
        }

       // System.out.println("Evaluating for trades file : "+tradesJsonFilePath+"  and clients : "+clientsFilePath);

        // service threads
        for (ClientService clientService : clientServiceList) {
            clientService.start(); // (worker 3)
        }

        // FSM service to consume trades from queue
        new FsmConsumer(tradesProducer, clientServiceList).start(); // (worker 2)

        //System.out.println("Trading threads running....");

    }

}
