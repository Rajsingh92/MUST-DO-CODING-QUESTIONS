'''
Generate binary string 
Given a string containing of ‘0’, ‘1’ and ‘?’ wildcard characters, generate all binary strings that can be formed by 
replacing each wildcard character by ‘0’ or ‘1’.

'''

def generateString(str,index):
    if index == len(str):
        print(''.join(str),end=" ")
        return
    
    if str[index] == '?':
        str[index] = '0'
        generateString(str,index+1)
        
        str[index] = '1'
        generateString(str,index+1)
        
        str[index] = '?'  #resore value as it is passed by reference
    else:
        generateString(str,index+1)