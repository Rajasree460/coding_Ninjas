#include <bits/stdc++.h>

double dist(double x1,double y1,double x2,double y2){
	return sqrt((x1-x2)*(x1-x2) +(y1-y2)*(y1-y2));
}

double totalDis(double x,int a, int b, int c, vector<vector<int>> &p){
	double y= -((a*x+c)/b);
	double ans=0;
	for(int i=0;i<p.size();i++){
		ans+=dist(x,y,(double)p[i][0],(double)p[i][1]);
	}
	return ans;
}
double optimumDistance(int a, int b, int c, vector<vector<int>> &points, int n){
	// Write your code here
	double start =-100, end=100, diff=1e-6;
	while(end-start>diff){
		double m1=start +(end-start)/3;
		double m2=end -(end-start)/3;

		double f1=totalDis(m1,a,b,c,points);
		double f2=totalDis(m2,a,b,c,points);

		if(f1>f2) start =m1;
		else if(f1<f2) end=m2;
		else{
			start=m1;
			end=m2;
		}

	}
	double x=(start+end)/2;
	return totalDis(x,a,b,c,points);
}
