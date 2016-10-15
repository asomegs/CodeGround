package baekjun.p2445;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        int N = 8;
        
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j <= i; j ++) {
                System.out.print("*");
            }
            for(int k = 0; k < 2*N - 2 - i*2; k ++) {
                System.out.print(" ");
            }
            for(int l = 0; l <= i; l ++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for(int i = N-2; i >= 0; i --) {
            for(int j = 0; j <= i; j ++) {
                System.out.print("*");
            }
            for(int k = 0; k < 2*N - 2 - i*2; k ++) {
                System.out.print(" ");
            }
            for(int l = 0; l <= i; l ++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}