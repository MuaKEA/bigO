package com.company;

public class BigONotation {
    private int[] theArray;
    private int arraySize;
    private int itemsInArray = 0;
    static long startTime;
    static long endTime;

    //O(n log n)
    public void quickSort(int left, int right){
        if(right - left <=0)
            return;
        else{
            int pivot = theArray[right];
            int pivotLocation = partitionArray(left, right, pivot);
            quickSort(left, pivotLocation - 1);
            quickSort(pivotLocation + 1, right);
        }
    }

    public int  partitionArray(int left, int right, int pivot){
        int leftPointer = left -1;
        int rightPointer = right;

        while(true){
            while(theArray[++leftPointer] < pivot);

            while(rightPointer > 0 && theArray[--rightPointer] > pivot);
            if(leftPointer >= rightPointer){
                break;
            }else{
                swapValues(leftPointer, rightPointer);

            }
        }
        swapValues(leftPointer, right);
        return leftPointer;
    }


    public BigONotation(int size) {
        arraySize = size;
        theArray = new int[size];
    }

    public static void main(String[] args){
        BigONotation testAlgo2 = new BigONotation(100000);
        testAlgo2.generateRandomArray();

        BigONotation testAlgo3 = new BigONotation(200000);
        testAlgo3.generateRandomArray();

        BigONotation testAlgo4 = new BigONotation(300000);
        testAlgo4.generateRandomArray();

        BigONotation testAlgo5 = new BigONotation(400000);
        testAlgo5.generateRandomArray();

        testAlgo2.quickSort(0, testAlgo2.itemsInArray);

        endTime = System.currentTimeMillis();
        System.out.println("Quick Sort Took " + (endTime - startTime));
    }
    //O(1) algoritme, der eksekverer på samme tid uanset arrayets størrelse
    public void addItemToArray(int newItem){
        theArray[itemsInArray++] = newItem;
    }

    /*O(log N)

     */

    public void binarySearchForValue(int value){
        startTime = System.currentTimeMillis();
        int lowIndex = 0;
        int highIndex = arraySize - 1;

        int timesThrough = 0;
        while(lowIndex <= highIndex){
            int middleIndex = (highIndex + lowIndex)/2;
            if(theArray[middleIndex] < value)
                lowIndex = middleIndex +1;

            else if(theArray[middleIndex] > value)
                highIndex = middleIndex - 1;

            else{
                System.out.println("Found Match in index " + middleIndex);
                lowIndex = highIndex + 1;

            }

            timesThrough++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("BubbleSort Took " + (endTime - startTime));
        System.out.println("Times Through " + timesThrough);
    }

    /*O(N)Algoritme, dvs køretiden stiger lineært i takt med sit input.(eks. arraylist)
    Når man skal gå hvert eneste element i en liste, dvs. O(1), O(2), O(3) osv.
    indtil man finder det rigtige element
     */
    public void linearSearchForValue(int value){
        boolean valueInArray = false;
        String indexsWithValue = "";

        startTime = System.currentTimeMillis();
        for(int i = 0; i < arraySize; i++){
            if(theArray[i] == value){
                valueInArray = true;
                indexsWithValue += i + " ";
                endTime = System.currentTimeMillis();
                System.out.println("Linear Search Took: " + (endTime - startTime));
            }
        }

        System.out.println("Value Found: " + valueInArray);

    }

    public void bubblesort(){
        startTime = System.currentTimeMillis();

        for(int i = arraySize -1; i>1; i--){
            for(int j = 0; j<i; j++){
                if(theArray[j] > theArray[j+1]){
                    swapValues(j, j+1);
                }
            }
        }

    }

    public void generateRandomArray(){
        for(int i = 0; i < arraySize; i++){
            theArray[i] = (int) (Math.random() * 1000) + 10;
        }

    }

    public void swapValues(int indexOne, int indexTwo){
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexOne] = temp;
    }
}