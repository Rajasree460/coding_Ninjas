from os import *
from sys import *
from collections import *
from math import *

from typing import *

def findKth(N: int, K: int) -> int:

    

     # Generate array 'A' from 1 to N.

    A = list(range(1, N + 1))

 

     # Sort array 'A' in lexicographical order

    A.sort(key=str)

 

   #Return K th position element of an array.

    return A[K-1]
