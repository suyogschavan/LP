import java.util.Scanner;

public class FIFO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int frames, inputs;
        System.out.println("Enter the number of frames: ");
        frames = sc.nextInt();
        System.out.println("Enter the number of Inputs");
        inputs = sc.nextInt();
        int inputStream[] = new int[inputs];
        int frameStream[] = new int[frames];
        System.out.println("Enter the inputs : ");
        for (int i = 0; i < inputs; i++) {
            inputStream[i] = sc.nextInt();
        }

        int Hit = 0;
        int Fault = 0;
        int j = 0;
        boolean check;
        for (int i = 0; i < inputs; i++) {
            check = false;

            for (int k = 0; k < frames; k++)
                if (frameStream[k] == inputStream[i]) {
                    check = true;
                    Hit++;
                }
            if (check == false) {
                frameStream[j] = inputStream[i];
                j++;
                if (j >= frames)
                    j = 0;
                Fault++;
            }

        }
        float ratio = (float)Hit/(float)inputs;
        System.out.println("Hit: "+Hit+" Fault: "+Fault+" Hit ratio: "+ratio);
        // System.out.println(inputs-1);
    }
}


// Enter the number of frames: 
// 3
// Enter the number of Inputs
// 10
// Enter the inputs :
// 1 
// 2
// 3
// 4
// 1
// 2
// 4
// 2
// 3
// 1
// Hit: 3 Fault: 7 Hit ratio: 0.3
