import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class MyObjectTest
{

    public int finding_largest(ArrayList<Integer> b, int size)
    {
        if(size == 1)
            return b.get(0);

        return Math.max(b.get(size-1), finding_largest(b, size-1));
    }

    public int largestSmaller (int[] a , int v)
    {
        ArrayList<Integer> b = null;
        for( int i =0; i< a.length; i++)
        {
            if(a[i] > v)
            {
                b.add(a[i]);
            }
        }
        int max = finding_largest(b,b.size());
        return max;
    }


    
    public static  void main( String[] args)
    {
        
    }

}

