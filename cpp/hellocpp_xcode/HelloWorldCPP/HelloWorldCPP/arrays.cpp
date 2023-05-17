//
//  arrays.cpp
//  HelloWorldCPP
//
//  Created by 胡帅帅 on 5/17/23.
//

#include "arrays.hpp"
#include <iostream>

using namespace std;

void three_dimen_arr(){
    int x,y,z; // [2,3,4]
    
    // 
    int ***p; // declare p
    p = new int **[2]; // layer-1
    
    for (int i = 0; i<2; i ++){
        p[i] = new int *[3]; // layer-2
        
        for(int j = 0; j < 4; j++){
            p[i][j] = new int [4]; // layer-3
        }
    }
    
    // traverse
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 4; k++) {
                p[i][j][k] = i + j + k;
                
                cout << p[i][j][k] ;
            }
        }
        cout << endl;
    }
    
    // free memory
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
            delete [] p[i][j]; // ~L3
        }
    }
    
    for (int i = 0; i < 2; i++) {
        delete [] p[i]; // ~L2
    }
    
    delete [] p; // ~L1
}
