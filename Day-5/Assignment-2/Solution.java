/**
 * @author Bollu Himana
 *
 */
class Solution{
    public static double[] dynamicMedian(double[] arr){
        double median=0;
        MaxPQ<Double> maxpq= new MaxPQ<>();
        MinPQ<Double> minpq= new MinPQ<>();
        for(int i=0;i<arr.length;i++){  //iterating i till length of an array
            if(arr[i]>median){          //checks whether the array value is greater than median or not
                minpq.insert(arr[i]);
            }
            else{
                maxpq.insert(arr[i]);
            }
            if(minpq.size()>maxpq.size()+1){
                maxpq.insert(minpq.delMin());
            }
            if(maxpq.size()>minpq.size()+1){
                minpq.insert(maxpq.delMax());
            }
            if(minpq.size()==maxpq.size()){
                median=(minpq.min()+maxpq.max())/2;
            }
            else if(minpq.size()>maxpq.size()){
                median=minpq.min();
            }
            else{
                median=maxpq.max();
            }
            arr[i]=median;
        }
        return arr;
    }
}