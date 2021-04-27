package com.razorpay.model.constraints;


public class RangeConstraints<T> implements  Constraints<T> {

    private long lowerLimit;
    private long upperLimit;
    private boolean lowerLimitInclusive;
    private boolean upperLimitInclusive;

    public  RangeConstraints(final long lowerLimit, final long upperLimit,
                            final boolean lowerLimitInclusive, final boolean upperLimitInclusive) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.lowerLimitInclusive = lowerLimitInclusive;
        this.upperLimitInclusive = upperLimitInclusive;
    }


    public boolean isValid(T number) {
        if (number instanceof Integer) {
            return isValid((Integer) number);
        }
        return false;
    }

    private boolean isValid(Integer number) {

        if(number>upperLimit)
        {
            return false;
        }
        return  true;

//        if (lowerLimitInclusive && number < lowerLimit) {
//            return false;
//        } else if (number <= lowerLimit) {
//            return false;
//        }
//
//        if (upperLimitInclusive && number > upperLimit) {
//            return false;
//        } else if (number >= upperLimit) {
//            return false;
//        }
//        return true;
    }


}
