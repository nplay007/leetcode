// Infix to Postfix Conversion

// 1. Scan the tokens from left to right.
// 2. If you encounter a number token, move it immediately to the result queue.
// 3. If you encounter an operator and the operator stack is empty, push the operator on the stack.
// 4. If you encounter an operator whose precedence is greater than that of the operator at the top of the stack, push the new operator on the stack.
// 5. If you encounter an operator whose precedence is less than or equal to the precedence of the operator at the top of the stack, pop the stack and
//    move the operator from the stack to the output queue. Repeat this step until either the stack empties or an operator appears at the top of the 
//    stack whose precedence is smaller than the precedence of the current operator. Push the new operator on the stack.
// 6. When you reach the end of the input, move any remaining operators from the stack to the result queue.

// Handling Parentheses 
// The algorithm is relatively easy to modify to handle parentheses. Whenever you encounter an open parenthesis, push it on the stack. 
// When you encounter a close parenthesis, pop operators off the stack and move them to the output queue until you encounter the matching open
// parenthesis.


// PREC_TABLE matches order of Token enumeration
struct Precedence
{
    int inputSymbol;
    int topOfStack;
} PREC_TABLE [ ] =
{
    { 0, -1 }, { 0, 0 },       // EOL, VALUE
    { 100, 0 }, { 0, 99 },     // OPAREN, CPAREN
    { 6, 5 },                  // EXP
    { 3, 4 }, { 3, 4 },        // MULT, DIV
    { 1, 2 }, { 1, 2 }         // PLUS, MINUS
};


template <typename NumericType>
class Evaluator
{
public:
  Evaluator( const string & s ) : str( s )
    { opStack.push_back( EOL ); }

      // The only publicly visible routine
  NumericType getValue( );          // Do the evaluation

private:
  stack<TokenType>   opStack;      // Operator stack for conversion
  stack<NumericType> postFixStack; // Stack for postfix machine

  istringstream str;                // String stream

      // Internal routines
  NumericType getTop( );                // Get top of postfix stack
  void binaryOp( TokenType topOp );     // Process an operator
  void processToken(const Token<NumericType> &lastToken);
   // Handle LastToken
};


// Public routine that performs the evaluation.
// Examines the postfix stack to see if a single result
// is left and if so, returns it; otherwise prints error.
template <class NumericType>
NumericType Evaluator<NumericType>::getValue( )
{
    Tokenizer<NumericType> tok( str );
    Token<NumericType> lastToken;

    do
    {
        lastToken = tok.getToken( );
        processToken( lastToken );
    } while( lastToken.getType( ) != EOL );

    if( postFixStack.isEmpty( ) )
    {
        cerr << "Missing operand!" << endl;
        return 0;
    }

    NumericType theResult = postFixStack.top( );
    postFixStack.pop( );
    if( !postFixStack.isEmpty( ) )
        cout << "Warning: missing operators!" << endl;

    return theResult;
}

// After token is read, use operator precedence parsing
// algorithm to process it; missing opening parentheses
// are detected here.
template <class NumericType>
void Evaluator<NumericType>::processToken(const Token<NumericType> & lastToken )
{
    TokenType topOp;
    TokenType lastType = lastToken.getType( );

    switch( lastType )
    {
      case VALUE:
        postFixStack.push( lastToken.getValue( ) );
        return;

      case CPAREN:
        while( ( topOp = opStack.top( ) ) != OPAREN && topOp != EOL )
            binaryOp( topOp );
        if( topOp == OPAREN )
            opStack.pop( );  // Get rid of opening parentheseis
        else
            cout << "Missing open parenthesis" << endl;
        break;

      default:    // General operator case
        while( PREC_TABLE[ lastType ].inputSymbol <=
               PREC_TABLE[ topOp = opStack.top( ) ].topOfStack )
            binaryOp( topOp );
        if( lastType != EOL )
            opStack.push( lastType );
        break;
    }
}

// top and pop the postfix machine stack; return the result.
// If the stack is empty, print an error message.
template <class NumericType>
NumericType Evaluator<NumericType>::getTop( )
{
    if( postFixStack.isEmpty( ) )
    {
        cout << "Missing operand" << endl;
        return 0;
    }

    NumericType tmp = postFixStack.top( );
    postFixStack.pop( );
    return tmp;
}

// Process an operator by taking two items off the postfix
// stack, applying the operator, and pushing the result.
// Print error if missing closing parenthesis or division by 0.
template <class NumericType>
void Evaluator<NumericType>::binaryOp( TokenType topOp )
{
    if( topOp == OPAREN )
    {
        cout << "Unbalanced parentheses" << endl;
        opStack.pop( );
        return;
    }
    NumericType rhs = getTop( );
    NumericType lhs = getTop( );

    if( topOp == EXP )
        postFixStack.push( pow( lhs, rhs ) );
    else if( topOp == PLUS )
        postFixStack.push( lhs + rhs );
    else if( topOp == MINUS )
        postFixStack.push( lhs - rhs );
    else if( topOp == MULT )
        postFixStack.push( lhs * rhs );
    else if( topOp == DIV )
        if( rhs != 0 )
            postFixStack.push( lhs / rhs );
        else
        {
            cout << "Division by zero" << endl;
            postFixStack.push( lhs );
        }

    opStack.pop( );
}

// A simple main to exercise Evaluator class.
int main( )
{
    string str;

    while( getline( cin, str ) )
    {
        Evaluator<int> e( str );
        cout << e.getValue( ) << endl;
    }

    return 0;
}