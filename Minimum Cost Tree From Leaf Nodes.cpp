/*
    Time complexity: O(N)
    Space Complexity: O(1)

    Where 'N' is the number of leaf nodes.
*/

#include<stack>
#include<climits>

int minimumCostTreeFromLeafNodes(vector<int> &arr) {
	// Create a variable to store the answer.
	int ans = 0;

	// Create a stack.
	stack<int>st;

	// Push INT_MAX intially in the stack to avoid any boundary value situations.
	st.push(INT_MAX);

	// Now Start travsering over the array.
	for (auto x : arr) {
		/*
		   Till the top of the stack is less than equal to
		   current element of the array do the following.
		*/
		while (st.top() <= x) {
			int temp = st.top();
			st.pop();
			ans += temp * min(st.top() , x);
		}
		st.push(x);
	}

	// If still the size of stack is greater than 2.
	while (st.size() > 2) {
		int temp = st.top();
		st.pop();
		ans += (temp * st.top());
	}
	// Finally return the answer.
	return ans;
}
