/**************************************************************************************
*   ITESS-TICS 2025
*   ICPC-CP SRPING JAKARTA
*   by FJMP
*   Array example
*   Programmer: FJMP
*   22/enero/2025
*
*  win: c++ e01_array.cpp -o e01_array.exe
*  linux mac c++ e01_array.cpp -o e01_array
*  cmd: e01_array.exe
*   ps: .\e01_array.exe
*  linux mac. ./e01_array
**************************************************************************************/

// librerias
#include <iostream>
#include <array>

using namespace std;

int main() 
{
    std::array<int, 10> arr;

    arr[0] = 1;
    std::cout << "First element:" << arr[0] << std::endl;

    array<int, 4> arr2 = {1, 2, 3, 4};
    cout << "Elements in second array: ";
    for(int i = 0; i < arr.size(); i++)
        cout << arr2[i] << " ";
    cout << endl;

    // exception
    try 
    {
        cout << arr2.at(4);
        cout << arr2.at(5);
    } 
    catch (const out_of_range& ex) 
    {
        cerr <<"EXCEPTION: " << ex.what();
    }
}