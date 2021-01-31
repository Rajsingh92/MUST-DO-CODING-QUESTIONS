// EVALUATE POSTFIX
public class EvaluationPostfixExpression {

    static int evaluatePostfix(String exp)
       {
           Stack<Integer> stack=new Stack<>();
           for(int i=0;i<exp.length();i++)
           {
               char c=exp.charAt(i);
               if(Character.isDigit(c))
                   stack.push(c - '0');
               else
               {
                   int val1 = stack.pop();
                   int val2 = stack.pop();
                    
                   switch(c)
                   {
                       case '+':
                       stack.push(val2+val1);
                       break;
                        
                       case '-':
                       stack.push(val2- val1);
                       break;
                        
                       case '/':
                       stack.push(val2/val1);
                       break;
                        
                       case '*':
                       stack.push(val2*val1);
                       break;
                 }
               }
           }
           return stack.pop();    
       }
}
// INFIX EVALUATION
public class EvaluationInfixExpression {

    public static void evaluateInfix(String exp) {
        Stack < Integer > operands = new Stack < > ();
        Stack < Character > operators = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' &&
                    precedence(ch) <= precedence(operators.peek())) {
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();

                    int opval = operation(val1, val2, op);
                    operands.push(opval);
                }

                operators.push(ch);
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();

                    int opval = operation(val1, val2, op);
                    operands.push(opval);
                }

                if (operators.size() > 0) {
                    operators.pop();
                }
            }
        }

        while (operators.size() > 0) {
            int val2 = operands.pop();
            int val1 = operands.pop();
            char op = operators.pop();

            int opval = operation(val1, val2, op);
            operands.push(opval);
        }

        int val = operands.pop();
        System.out.println(val);
    }

    public static int precedence(char op) {
        if (op == '+') {
            return 1;
        } else if (op == '-') {
            return 1;
        } else if (op == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    public static int operation(int val1, int val2, char op) {
        if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val1 - val2;
        } else if (op == '*') {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }
}
// PREFIX EVALUATION
public class EvaluationPrefixExpression {

    public static void evaluatePrefix(String exp) {
        Stack < Integer > vstack = new Stack < > ();
        Stack < String > infix = new Stack < > ();
        Stack < String > prefix = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
                int v2 = vstack.pop();
                int v1 = vstack.pop();
                int val = operation(v1, v2, ch);
                vstack.push(val);

                String inv2 = infix.pop();
                String inv1 = infix.pop();
                String inv = "(" + inv1 + ch + inv2 + ")";
                infix.push(inv);

                String prev2 = prefix.pop();
                String prev1 = prefix.pop();
                String prev = ch + prev1 + prev2;
                prefix.push(prev);
            } else {
                vstack.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            }
        }

        System.out.println(vstack.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }

    public static int operation(int v1, int v2, char op) {
        if (op == '+') {
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;
        } else if (op == '*') {
            return v1 * v2;
        } else if (op == '/') {
            return v1 / v2;
        } else {
            return 0;
        }
    }
}


// INFIX TO POSTFIX
public class InfixToPostfix {
	public static String inToPost(String str) {
		String rv = "";

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int val = (int) ch;
			// System.out.println(val);
			if (val >= 97 && val <= 122) {
				rv += ch;
			} else {
				int myPref = preference(ch);
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {

					if (ch == '(') {
						stack.push(ch);

					} else if (ch == ')') {

						while (!stack.isEmpty() && stack.peek() != '(') {
							rv += stack.pop();
						}
						stack.pop();

					} else {
						while (true) {

							if (stack.isEmpty()) {
								stack.push(ch);
								break;
							}
							char stackTop = stack.peek();

							int topPref = preference(stackTop);
							if (topPref < myPref) {
								stack.push(ch);
								break;
							} else {
								rv += stack.pop();

							}
						}
					}
				}

			}

			//System.out.println(ch + "," + stack + ", " + rv);
		}
		while (!stack.isEmpty()) {
			rv += stack.pop();
		}

		return rv;
	}

	public static int preference(char ch) {

		if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '^') {
			return 3;
		}

		return 0;
	}

}


// INFIX CONVERSION
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack < String > postfix = new Stack < > ();
        Stack < String > prefix = new Stack < > ();
        Stack < Character > operators = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                postfix.push(ch + "");
                prefix.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())) {
                    char op = operators.pop();

                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    postfix.push(postval1 + postval2 + op);

                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    prefix.push(op + preval1 + preval2);
                }

                operators.push(ch);
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    char op = operators.pop();

                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    postfix.push(postval1 + postval2 + op);

                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    prefix.push(op + preval1 + preval2);
                }

                if (operators.size() > 0) {
                    operators.pop();
                }
            }
        }

        while (operators.size() > 0) {
            char op = operators.pop();

            String postval2 = postfix.pop();
            String postval1 = postfix.pop();
            postfix.push(postval1 + postval2 + op);

            String preval2 = prefix.pop();
            String preval1 = prefix.pop();
            prefix.push(op + preval1 + preval2);
        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }

    public static int precedence(char op) {
        if (op == '+') {
            return 1;
        } else if (op == '-') {
            return 1;
        } else if (op == '*') {
            return 2;
        } else {
            return 2;
        }
    }
}











