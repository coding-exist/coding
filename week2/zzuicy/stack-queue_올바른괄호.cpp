#include<string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    const char open = '(';
    const char close = ')';
    stack<char> charStack;
    for (auto c : s)
    {
        if (c == open)
            charStack.push(c);
        else if (c == close)
        {
            if (charStack.empty())
                return false;
            
            auto topChar = charStack.top();
            if (topChar != open)
                return false;
            else
                charStack.pop();
        }
    }
    
    if (charStack.size() > 0)
        return false;
    
    return true;
}