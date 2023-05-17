//
//  multi_threads_demo.cpp
//  HelloWorldCPP
//
//  Created by 胡帅帅 on 5/16/23.
//

#include "multi_threads_demo.hpp"
#include <pthread.h> // before C++11
#include <thread> // C++11 std::thread
#include <iostream>

using namespace std;

#define NUM_THREADS 5
