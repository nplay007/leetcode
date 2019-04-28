// There is a very simple algorithm for evaluating postfix expressions.

// Scan the expression from left to right.
// Push any numbers you encounter on a value stack.
// Any time you encounter an operator, pop the top two numbers off the value stack, apply the operation to them, and push the result back on the stack.
// The number that appears at the top of the stack at the end of the scan is the result of the calculation.

#include <stack>
#include <iostream>
#include "token.h"

using namespace std;

typedef Token<int> tokenType;

int pow(int x,int y)
{
  int result = 1;
  while(y > 0)
  {
    result *= x;
    y--;
  }
  return result;
}

int main()
{
  stack<tokenType> s;
  
  Tokenizer<int> t(cin);

  tokenType curToken = t.getToken();
  while(curToken.getType() != EOL)
  {
    // Process the current token
    switch(curToken.getType())
    {
    case EOL:
      break;
    case VALUE:
      s.push(curToken);
      break;
    case OPAREN:
    case CPAREN:
      break;
    case EXP:
      {
      tokenType op1 = s.top();
      s.pop();
      tokenType op2 = s.top();
      s.pop();
      int result = pow(op2.getValue(),op1.getValue());
      s.push(Token<int>(VALUE,result));
      break;
      }
    case MULT:
      {
      tokenType op1 = s.top();
      s.pop();
      tokenType op2 = s.top();
      s.pop();
      int result = op2.getValue()*op1.getValue();
      s.push(Token<int>(VALUE,result));
      break;
      }
    case DIV:
      {
      tokenType op1 = s.top();
      s.pop();
      tokenType op2 = s.top();
      s.pop();
      int result = op2.getValue()/op1.getValue();
      s.push(Token<int>(VALUE,result));
      break;
      }
    case PLUS:
      {
      tokenType op1 = s.top();
      s.pop();
      tokenType op2 = s.top();
      s.pop();
      int result = op2.getValue()+op1.getValue();
      s.push(Token<int>(VALUE,result));
      break;
      }
    case MINUS:
      {
      tokenType op1 = s.top();
      s.pop();
      tokenType op2 = s.top();
      s.pop();
      int result = op2.getValue()-op1.getValue();
      s.push(Token<int>(VALUE,result));
      break;
      }
    }
    curToken = t.getToken();
  }

  tokenType last = s.top();
  cout << "Result: " << last.getValue() << endl;

  return 0;
}