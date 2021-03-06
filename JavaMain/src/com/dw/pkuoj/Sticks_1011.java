package com.dw.pkuoj;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;


/*
 * Sample Input

9
5 2 1 5 2 1 5 2 1
4
1 2 3 4
0
Sample Output

6
5
 * */

/*
 * 9
15 3 2 11 4 1 8 8 8
6
6 2 2 4 8 8
5
1 1 1 1 1 
2
1 1
4
2 2 9 9

3
1 2 3

64
40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 
40 40 43 42 42 41 10 4 40 40 40 40 40 40 40 40 40 40 40 40 40 
40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 40 
40 

7
49 48 47 46 45 44 43

7
3 4 5 5 5 5 13

7
2 7 7 7 7 10 20

6
1 2 3 11 11 20

7
63 2 44 12 60 35 60 

9
5 2 1 5 2 1 5 2 1

4
1 2 3 4

64
32 32 32 32 32 32 32 32 32 32
32 32 32 32 32 32 32 32 32 32
32 32 32 32 32 32 32 32 32 32
32 32 32 32 32 32 32 32 32 32
32 32 32 32 32 32 32 32 32 32
32 32 32 32 32 32 32 32 32 32
33 33 31 31

64
40 40 30 35 35 26 15 40 40 40 40 40 40 40 40 40 40 40 40 40 40 
40 40 43 42 42 41 10 4 40 40 40 40 40 40 40 40 40 40 40 40 40 
40 25 39 46 40 10 4 40 40 37 18 17 16 15 40 40 40 40 40 40 40 
40


45
15 3 2 11 4 1 8 8 8 15 3 2 11 4 1 8 8 8 15 3 2 11 4 1 8 8 8 15 3 2 11 4 1 8 8 8
15 3 2 11 4 1 8 8 8
0


answer:
20
10
1
1
11
3
1251
322
20
30
24
276
6
5
64
454
20
 * 
 * */

public class Sticks_1011 {
	
	/*
	 * add psudocode here
	 * sum of all sticks
	 * 
	 * foo() {
	 * 
	 * 
	 * 		  
	 * }
	 * 
	 * Arrays.sort(array);
	 * 
	 * max = findMaxSize(array);
	 * 
	 * for(int i=max+1;i<=sum;i++) {
	 *    if(sum %i == 0) {
	 *       
	 *    }
	 * }
	 */
	
	public static int[] boolArray = new int[100];
	
	public static int totalLen = 0;
	public static int totalPart = 0;
	public static boolean isFull = false;
	
	public static void reverse(int[] array) {
	    for(int i=0;i<=array.length/2-1;i++) {
	        int temp = array[i];
	        array[i]=array[array.length - 1 - i];
	        array[array.length - 1 - i] = temp;
	    }
	}
	
	public static void main(String[] args) {
		
        FileInputStream instream = null;
        PrintStream outstream = null;
        
        try{
            instream = new FileInputStream("/Users/ewu/data/1.txt");
            outstream = new PrintStream("/Users/ewu/data/1.out");
            System.setIn(instream);
            System.setOut(outstream);
        }
        catch(Exception e){
            System.err.println("Error Occurred");
        }

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0) {
	        int[] array = new int[T];
	        
	        
            for(int j=0;j<T;j++){
                array[j] = in.nextInt();
            }
            T = in.nextInt();
            
            int sum = 0;
            for(int i=0;i<array.length;i++) {
            	sum += array[i];
            	boolArray[i] = 0;
            }
            
            Arrays.sort(array);
            reverse(array);
            
            //for(int i=0;i<array.length;i++)
            //	System.out.print(array[i] + "\t");
            
            for(int i=array[0];i<=sum;i++) {
            	if(sum == i) {
            		System.out.println(i);
            		break;
            	}
            	if(sum%i == 0) {
            		isFull = false;
            		totalPart = sum/i;
            		totalLen = i;
            		for(int k=0;k<boolArray.length;k++) {
            			boolArray[k] = 0;
            		}
            		
            		checkValid(array,i,0,totalPart);
            		if(isFull) {
            			System.out.println(i);
            			break;
            		}
            	}
            }
        }
		
	}
	
	public static boolean checkValid(int array[], int remainLen,int startIndex,int remainPart) {
		if(isFull) return isFull;
		//System.out.println("xixi");
		for(int i=startIndex;i<array.length;i++) {
			if(isFull) return isFull;
			if(boolArray[i] == 1) continue;
			
			if(remainLen > array[i]) {
				boolArray[i] = 1;
				if(checkValid(array,remainLen - array[i],i, remainPart) == false) {
					boolArray[i] = 0;
					if(remainLen == totalLen) 
						return false; 
					
					continue;
				}
				return true;
			}
			else if(remainLen == array[i]) {
				boolArray[i] = 1;
				remainPart -=1;
				
				if(remainPart == 0) {
					isFull = true;
					return true;
				}
				
				if(checkValid(array,totalLen, 0 , remainPart) == false) {
					boolArray[i] = 0;
					remainPart += 1;
					if(remainLen == totalLen)
						return false; 
					
					continue;
				}
			}
		}
		
		return false;
	}
}

/*
 * #include <iostream>
 
using namespace std;
 
int in[51]; //长度为i的片段个数
int length; //棒子的原始长度
int finish; //终止标志（非0即终止）
 //
 // 遍历
 // @param count 棒子的总数（如果为0，则结束）
 // @param len 目前检查的棒子长度的剩余量
 // @param plen 现在检查的片段长度

void check(int count, int len, int plen)
{
    --in[plen]; //取一个长度是plen的片段来用
    if (count == 0)
        finish = 1;
    if (!finish)
    {
        len -= plen;
        if (len != 0)
        {
            int next_plen = min(len, plen); //剪枝策略：用plen去凑len，next_plen必须是较小者
            for (; next_plen > 0; --next_plen)
                if (in[next_plen])  //有剩余
                    check(count, len, next_plen);
        }
        else
        {
            //片段长度最大为50
            int max = 50;
            while (!in[max])
                --max;
            check(count - 1, length, max);
        }
    }
    ++in[plen]; //恢复原始状态
}
 
 
int main()
{
#ifndef ONLINE_JUDGE
    freopen("in.txt", "r", stdin);
#endif
    int n;
    while (~scanf("%d", &n) && n)
    {
        memset(in, 0, sizeof(in));
        int sum = 0;
        int max = 0;
        finish = 0;
        while (n--)
        {
            int b;
            scanf("%d", &b);
            ++in[b];
            sum += b;
            if (max < b)
                max = b;
        }
        length = max;
        while (true)
        {
            if (sum % length == 0)
                check(sum / length, length, max);
            if (finish)
                break;
            ++length;
        }
        printf("%d\n", length);
    }
#ifndef ONLINE_JUDGE
    fclose(stdin);
#endif
}

http://www.hankcs.com/program/algorithm/poj-1011-sticks.html
 * 
 * */
