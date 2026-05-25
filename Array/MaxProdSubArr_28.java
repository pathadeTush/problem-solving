public class MaxProdSubArr_28 {

    /*
     * Scenarios:
     * Break arrays into sub arrays around 0 element
     * return maximum product of sub arrays
     * If product of sub array < 0:
     *   means there are odd negative elements
     *   So, for that sub array take prod as
     *       max(prod leaving last negative element starting from first, prod leaving first negative element starting from last)
     *
     *
     * */
    public static long maxProduct(int[] arr, int n) {
        long maxProd = Long.MIN_VALUE;
        long prod = 1;
        long prodFromLastNegEle = 1;
        long prodTillFirstNegEle = 1;
        int countSubArr = 0;
        for (int ele : arr) {
            if (ele == 0) {
                if (prod < 0) {
                    if(countSubArr > 2) {
                        maxProd = Math.max(maxProd, Math.max(prod / prodFromLastNegEle, prod / prodTillFirstNegEle));
                    } else if (countSubArr == 1) {
                        maxProd = Math.max(maxProd, prodFromLastNegEle);
                    }
                }

                maxProd = Math.max(ele, maxProd);
                prod = 1;
                prodTillFirstNegEle = 1;
                countSubArr = 0;
            } else {
                prod *= ele;
                if (ele < 0) {
                    prodFromLastNegEle = 1;
                    if (prod < 0 && prodTillFirstNegEle == 1) {
                        prodTillFirstNegEle = prod;
                    }
                }
                prodFromLastNegEle *= ele;
                countSubArr++;
            }

            maxProd = Math.max(maxProd, prod);
        }

        if (prod < 0) {
            if(countSubArr > 2) {
                maxProd = Math.max(maxProd, Math.max(prod / prodFromLastNegEle, prod / prodTillFirstNegEle));
            } else if (countSubArr == 1) {
                maxProd = Math.max(maxProd, prodFromLastNegEle);
            }
        }

        return maxProd;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 0, 4, -3, -2, -6, 7};
        System.out.println(maxProduct(arr, arr.length));
    }

}
