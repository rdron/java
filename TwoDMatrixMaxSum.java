import java.io.*;
import java.util.Scanner;

public class TwoDMatrixMaxSum{
	public int[][] array;
	public int[][] memo;
	public int row,col;
	public TwoDMatrixMaxSum(){
		System.out.println("Enter the dimensions of the array");
		Scanner in = new Scanner(System.in);
		this.row = in.nextInt();
		this.col = in.nextInt();
		this.array = new int[this.row][this.col];
		this.memo = new int[this.row][this.col];
		System.out.println("Enter the elements of the array in row wise order");
		for(int i = 0; i<this.row; i++){
			for(int j = 0; j<this.col; j++){
				this.array[i][j]=in.nextInt();
				this.memo[i][j]=-1;
			}
		}
	}
    public int maxSum(int i,int j){
    	if(memo[i][j]==-1){
    		int max;
	    	if(i==(this.row-1) && j==(this.col-1))
    			max = this.array[i][j];
	    	else if(i==(this.row-1))
    			max = this.array[i][j] + this.maxSum(i,j+1);
	    	else if(j==(this.col-1))
    			max = this.array[i][j] + this.maxSum(i+1,j);
	    	else {
    			int maxTemp = this.maxSum(i+1,j)>this.maxSum(i,j+1)?this.maxSum(i+1,j):this.maxSum(i,j+1);
    			max = this.array[i][j] + (maxTemp>this.maxSum(i+1,j+1)?maxTemp:this.maxSum(i+1,j+1));
    		
    		}
    		memo[i][j]=max;
    		return max;
    	}
    	return memo[i][j];
    	
    }
	public static void main(String[] args){
		TwoDMatrixMaxSum obj = new TwoDMatrixMaxSum();
		System.out.println(obj.maxSum(0,0));

	}
}