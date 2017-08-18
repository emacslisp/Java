package com.dw.leetcode;

public class Judge_Route_Circle_657 {

    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0 ) return true;

        int x = 0;
        int y = 0;
        for(int i=0;i<moves.length();i++) {
        	char c = moves.charAt(i);
        	
        	if(c == 'U') {
        		y++;
        	}
        	else if(c == 'D') {
        		y--;
        	}
        	else if(c== 'R') {
        		x++;
        	}
        	else if(c == 'L') {
        		x--;
        	}
        }
        
        return (x== 0 && y== 0);
    }
	
	public static void main(String[] args)	{
		// TODO Auto-generated method stub
		Judge_Route_Circle_657 s = new Judge_Route_Circle_657();
		System.out.println(s.judgeCircle("LL"));
	}

}
