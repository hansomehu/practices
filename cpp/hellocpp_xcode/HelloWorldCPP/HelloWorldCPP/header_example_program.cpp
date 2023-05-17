//
//  header_example_program.cpp
//  HelloWorldCPP
//
//  Created by 胡帅帅 on 5/15/23.
//

#include "header_example_program.hpp"
#include <iostream>
#include "header_example.hpp"

using namespace std;
using namespace example;

int main(int argc, char* argv[]){
    example::exmaple_class classDemo;
    classDemo.f2();
    classDemo.f3();	
    
    return 0;
}
