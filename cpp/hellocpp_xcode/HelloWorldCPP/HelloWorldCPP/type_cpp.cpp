//
//  type_cpp.cpp
//  HelloWorldCPP
//
//  Created by 胡帅帅 on 5/13/23.
//

/*
 demo of all data types in CPP
 */
#include <iostream>
using namespace std;

// CPP指针的练习
void pointers(){
    
    // 简单的取址操纵
    int var1;
    char var2[2]; // size of 2
    
    cout << "var1 address: " << &var1 << endl;
    cout << "var2 address: " << &var2 << endl;
    
    double *adr_var2; //type *var_name, type can be all the data types in CPP
    int* adr_var1; // represents a pointer that points to an integer type
    adr_var1 = &var1; // set value for a pointer variable
    cout << adr_var1 << endl;
    
    int* adr_var3 = nullptr; //
    
    
}

