package practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumEqualsK {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] arr =new int[n];
        String line= br.readLine();
        String[] temp=line.trim().split("\\s+");
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(temp[i]);
        int k= Integer.parseInt(br.readLine());
        List<int[]> li= threeSumK(arr,k);
        for (int[] ele:li)
            System.out.println(ele[0]+" "+ele[1]+" "+ele[2]);
        br.close();
    }

    private static List<int[]> threeSumK(int[] arr, int k){
        Arrays.sort(arr);
        List<int[]> list=new LinkedList<>();
        for(int i=0;i<arr.length-2;i++){
            if(i==0 || arr[i]!=arr[i-1])twoSum(arr,i+1,i,k,list);
        }
        return list;
    }

    private static void twoSum(int arr[], int i,int x, int k,List<int[]> list){
        int j= arr.length-1;
        int t=k-x;
        while(i<j){
            if(arr[i]+arr[j]<t)i++;
            else if (arr[i]+arr[j]>t)j--;
            else{
                list.add(new int[]{x, arr[i], arr[j]});
                while(i<j && arr[i]==arr[i+1])i++;
                while(i<j && arr[j]==arr[j-1])j--;
                i++;j--;
            }
        }
    }
}
