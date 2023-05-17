//
//  header_example.hpp
//  HelloWorldCPP
//
//  Created by 胡帅帅 on 5/15/23.
// 

#ifndef header_example_hpp
#define header_example_hpp

#pragma once // avoid loop dependency 避免头文件的循环依赖（预处理期间起作用）
#include <vector> // #include directive
#include <string>
#include <stdio.h>
#include <iostream>

using namespace std;

namespace example {

void f1();
const double PI = 3.14;

class exmaple_class{
    int e1;
    
public:
    void f2(){ cout << "f2 works" << endl;} // defined in header file (right here)
    void f3(); // defined in cpp file (explicit implementation needed)
};

}


/*
 examples of all the elements that could be in a namespace domain
 */
namespace N  // namespace declaration
{
    inline namespace P
    {
        //...
    }

    enum class colors : short { red, blue, purple, azure };

    const double PI = 3.14;  // const and constexpr definitions
    constexpr int MeaningOfLife{ 42 };
    constexpr int get_meaning()
    {
        static_assert(MeaningOfLife == 42, "unexpected!"); // static_assert
        return MeaningOfLife;
    }
    using vstr = std::vector<int>;  // type alias
    extern double d; // extern variable

#define LOG   // macro definition

#ifdef LOG   // conditional compilation directive
    void print_to_log();
#endif

    class my_class   // regular class definition,
    {                // but no non-inline function definitions

        friend class other_class;
    public:
        void do_something();   // definition in my_class.cpp
        inline void put_value(int i) { vals.push_back(i); } // inline OK

    private:
        vstr vals;
        int i;
    };

    struct RGB
    {
        short r{ 0 };  // member initialization
        short g{ 0 };
        short b{ 0 };
    };

    template <typename T>  // template definition
    class value_store
    {
    public:
        value_store<T>() = default;
        void write_value(T val)
        {
            //... function definition OK in template
        }
    private:
        std::vector<T> vals;
    };

    template <typename T>  // template declaration
    class value_widget;
}

#endif /* header_example_hpp */
