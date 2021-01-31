/**
class TwoStack:
    def __init__(self,n):
        self.size = n
        self.stack = [None]*n
        self.top1 = -1
        self.top2 = self.size
    
    def push1(self,x):
        if self.top2-self.top1>1:
            self.top1+=1
            self.stack[self.top1] = x
        else:
            print("Stack Overflow")

    def push2(self,x):
        if self.top2-self.top1>1:
            self.top2-=1
            self.stack[self.top2] = x
        else:
            print("Stack Overflow")

    def pop1(self):
        if self.top1>=0:
            x = self.stack[self.top1]
            self.top1-=1
        else:
            print("Stack Underflow")

    def pop2(self):
        if self.top2<self.size:
            x = self.stack[self.top2]
            self.top2+=1
        else:
            print("Stack Underflow")
 */


import java.io.*;
import java.util.*;

public class Main {

    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;

        public TwoStack(int cap) {
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return data.length - tos2;
        }

        void push1(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos2--;
                data[tos2] = val;
            }
        }

        int pop1() {
            if (tos1 == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2() {
            if (tos2 == data.length) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos2];
                tos2++;
                return val;
            }
        }

        int top1() {
            if (tos1 == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos1];
            }
        }

        int top2() {
            if (tos2 == data.length) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos2];
            }
        }
    }

   
}