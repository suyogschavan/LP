import java.util.*;
 
public class SRTF {
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println ("Enter the Number of Process:");
		int n= sc.nextInt();
		int pid[] = new int[n]; // it takes pid of process
		int at[] = new int[n]; // at means arrival time
		int bt[] = new int[n]; // bt means burst time
		int ct[] = new int[n]; // ct means complete time
		int ta[] = new int[n];// ta means turn around time
		int wt[] = new int[n];  // wt means waiting time
		int f[] = new int[n];  // f means it is flag it checks process is completed or not
		int k[]= new int[n];   // it is also stores brust time
	    int i, st=0, tot=0;
	    float avgwt=0, avgta=0;
 
	    for (i=0;i<n;i++)
	    {
	    	pid[i]= i+1;
	    	System.out.println ("Enter process " +(i+1)+ " Arrival time:");
	    	at[i]= sc.nextInt();
	    	System.out.println("Enter process " +(i+1)+ " Burst time:");
	    	bt[i]= sc.nextInt();
	    	k[i]= bt[i];
	    	f[i]= 0;
	    }
	    
	    while(true){
	    	int min=99,c=n;
	    	if (tot==n)
	    		break;
	    	
	    	for ( i=0;i<n;i++)
	    	{
	    		if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))
	    		{	
	    			min=bt[i];
	    			c=i;
	    		}
	    	}
	    	
	    	if (c==n)
	    		st++;
	    	else
	    	{
	    		bt[c]--;
	    		st++;
	    		if (bt[c]==0)
	    		{
	    			ct[c]= st;
	    			f[c]=1;
	    			tot++;
	    		}
	    	}
	    }
	    
	    for(i=0;i<n;i++)
	    {
	    	ta[i] = ct[i] - at[i];
	    	wt[i] = ta[i] - k[i];
	    	avgwt+= wt[i];
	    	avgta+= ta[i];
	    }
	    
	    System.out.println("Pid  Arrival  Burst  Complete Turn Waiting");
	    for(i=0;i<n;i++)
	    {
	    	System.out.println(pid[i] +"\t"+ at[i]+"\t"+ k[i] +"\t"+ ct[i] +"\t"+ ta[i] +"\t"+ wt[i]);
	    }
	    
	    System.out.println("\nAverage tat is "+ (float)(avgta/n));
	    System.out.println("Average wt is "+ (float)(avgwt/n));
	    sc.close();
	}
}


/*
Enter the Number of Process:
4
Enter process 1 Arrival time:
0
Enter process 1 Burst time:
8
Enter process 2 Arrival time:
1
Enter process 2 Burst time:
4
Enter process 3 Arrival time:
2
Enter process 3 Burst time:
9
Enter process 4 Arrival time:
3
Enter process 4 Burst time:
5
Pid  Arrival  Burst  Complete Turn Waiting
1	0	8	17	17	9
2	1	4	5	4	0
3	2	9	26	24	15
4	3	5	10	7	2

Average tat is 13.0
Average wt is 6.5
*/
