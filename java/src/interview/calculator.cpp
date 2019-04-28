enum TokenType { EOL, VALUE, OPAREN, CPAREN, EXP, MULT, DIV, PLUS, MINUS };

template <typename NumericType>
class Token
{
  public:
    Token( TokenType tt = EOL, const NumericType & nt = 0 )
      : theType( tt ), theValue( nt ) { }

    TokenType getType( ) const
      { return theType; }
    const NumericType & getValue( ) const
      { return theValue; }

  private:
    TokenType   theType;
    NumericType theValue;
};

template <typename NumericType>
class Tokenizer
{
  public:
    Tokenizer( istream & is ) : in( is ) { }

    Token<NumericType> getToken( );

  private:
    istream & in;
};

// Find the next token, skipping blanks, and return it.
// Print error message if input is unrecognized.
template <class NumericType>
Token<NumericType> Tokenizer<NumericType>::getToken( )
{
    char ch;
    NumericType theValue;

        // Skip blanks
    while( in.get( ch ) && ch == ' ' )
        ;

    if( in.good( ) && ch != '\n' && ch != '\0' )
    {
        switch( ch )
        {
          case '^': return EXP;
          case '/': return DIV;
          case '*': return MULT;
          case '(': return OPAREN;
          case ')': return CPAREN;
          case '+': return PLUS;
          case '-': return MINUS;

          default:
            in.putback( ch );
            if( !( in >> theValue ) )
            {
                cerr << "Parse error" << endl;
                return EOL;
            }
            return Token<NumericType>( VALUE, theValue );
        }
    }

    return EOL;
}

#include <stack>
#include <iostream>

#include "token.h"

using namespace std;

typedef Token<int> tokenType;

int main() {
	stack<tokenType> s;
	Tokenizer<int> t(cin);
	tokenType curToken = t.getToken();
	while(curToken.getType() != EOL) {
		// Process the current token
		if(curToken.getType() == OPAREN) s.push(curToken);
		else if(curToken.getType() == CPAREN) {
			if(s.isEmpty()) {
				cout << "Unbalanced close parenthesis." << endl;
				break;
			} else {
				s.pop();
			}
		}
		curToken = t.getToken();
	}

	if(!s.isEmpty())
		cout << "Unbalanced open parenthesis" << endl;
	else
		cout << "Expression balances." << endl;
	return 0;
}
