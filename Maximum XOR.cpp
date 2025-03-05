struct Node {
    Node* links[2]; 
    
    /*To check if a specific bit 
    key is present in the child nodes*/
    bool containsKey(int bit) {
        return (links[bit] != NULL);
    }
    
    /*To get child node 
    corresponding to a 
    specific bit*/
    Node* get(int bit) {
        return links[bit];
    }
    
    /*To set a child node at a specific 
    index in the links array*/
    void put(int bit, Node* node) {
        links[bit] = node;
    }
};

class Trie {
private:
    Node* root; 

public:
    // Constructor 
    Trie() {
        root = new Node();
    }
    
    // To insert number in Trie
    void insert(int num) {
        // Start from the root
        Node* node = root;
        // Iterate each bit
        for (int i = 31; i >= 0; i--) {
            // Extract i-th bit
            int bit = (num >> i) & 1;
           /* If the current node doesn't 
           have a child node with the 
           current bit*/
            if (!node->containsKey(bit)) {
                node->put(bit, new Node());
            }
            node = node->get(bit);
        }
    }
    
    // Method to find the maximum XOR 
    int getMax(int num) {
        // Start from root
        Node* node = root;
        // Initialize maximum XOR value
        int maxNum = 0;
        // Iterate each bit
        for (int i = 31; i >= 0; i--) {
            // Extract the i-th bit 
            int bit = (num >> i) & 1;
            /*If the complement of the current bit 
            exists in the Trie update the maximum 
            XOR value with the current bit
            move to the child node corresponding to 
            the complement of the current bit
            Else move to the child node 
            corresponding to the current bit*/
            if (node->containsKey(1 - bit)) {
                
                maxNum |= (1 << i);
                
                node = node->get(1 - bit);
            } else {
                node = node->get(bit);
            }
        }
        // Return maximum XOR
        return maxNum;
    }
};



int maxXOR(int n, int m, vector<int> &arr1, vector<int> &arr2) 
{
    // Write your code here.   

     // Create Trie
        Trie trie;
        // Insert number
        for (int num : arr1) {
            trie.insert(num);
        }
        
        // Maximum XOR value
        int maxi = 0;
        
        // Iterate each number
        for (int num : arr2) {
            // Update the maximum XOR
            maxi = max(maxi, trie.getMax(num));
        }
        
        // Return maximum XOR value
        return maxi;
}
