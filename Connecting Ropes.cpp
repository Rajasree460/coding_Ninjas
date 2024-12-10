#include <bits/stdc++.h> 
#define ll int

template <typename node, typename update>
struct segTree{
    ll len;
    vector<node> t;
    vector<update> u;
    vector<bool> lazy;
    vector<ll> tl,tr;
    node identity_element;
    update identity_transformation;

    template<typename T>
    segTree(T &a){
        len = a.size();
        t.resize(4 * len);
        u.resize(4 * len);
        lazy.resize(4 * len);
        tl.resize(4 * len);
        tr.resize(4 * len);
        identity_element = node();
        identity_transformation = update();
        build(a,1,0,len-1);
    }

    template <typename T>
    void build(const T &a, const ll &v, const ll &l, const ll &r){
        tl[v]=l;
        tr[v]=r;
        if (l == r){
            t[v]=a[l];
            return;
        }
        ll tm = (l + r) >> 1;
        build(a, v << 1, l, tm);
        build(a, v << 1 | 1, tm + 1, r);
        t[v].merge(t[v << 1], t[v << 1 | 1]);
    }

    void apply(const ll &v, update val){
        if (tl[v] != tr[v]){
            lazy[v] = 1;
            u[v].combine(val, tl[v], tr[v]);
        }
        val.apply(t[v], tl[v], tr[v]);
    }

    void pushdown(const ll &v){
        if(lazy[v]){
            apply(v << 1, u[v]);
            apply(v << 1 | 1, u[v]);
            u[v] = identity_transformation;
            lazy[v] = 0;
        }
    }
 
    // rupd = range update
    void rupd(const ll &v,const ll &l, const ll &r, update val){
        if (l > tr[v] || r < tl[v])
            return;
        if (tl[v] >= l && tr[v] <= r){
            apply(v,val);
            return;
        }
        pushdown(v);
        rupd(v << 1, l, r, val);
        rupd(v << 1 | 1, l, r, val);
        t[v].merge(t[v << 1], t[v << 1 | 1]);
    }

    node query(const ll &v,const ll &l, const ll &r){
        if (l > tr[v] || r < tl[v])
            return identity_element;
        if (tl[v] >= l && tr[v] <= r)
            return t[v];
        pushdown(v);
        node a,b,ans;
        a=query(v*2,l,r);
        b=query(v*2+1,l,r);
        ans.merge(a,b);
        return ans;
    }

    template<typename T>
    ll descent_right(ll l, T x, ll v, node &prev) {
        if (l > tr[v]) // node is completely out of range
            return len;
        if(l <= tl[v]){ // node is completely in range
            node cur;
            cur.merge(prev,t[v]);
            if (!cur.check(x)){ // go further right than this node
                swap(prev,cur); // merging this node's contribution
                return len;
            }
            if (tl[v]==tr[v]) {
                return tr[v];
            }
        }
        pushdown(v);
        ll ans=descent_right(l, x, v*2, prev); // trying to find in left child
        if(ans!=len)return ans; // found in left child
        return descent_right(l, x, v*2+1, prev); // finding in right child
    }
    template<typename T>
    ll descent_left(ll r, T x, ll v, node &prev) {
        if (r < tl[v]) // node is completely out of range
            return -1;
        if(r >= tr[v]){ // node is completely in range
            node cur;
            cur.merge(t[v],prev);
            if (!cur.check(x)){ // go further left than this node
                swap(cur,prev); // merging this node's contribution
                return -1;
            }
            if (tl[v]==tr[v]) {
                return tl[v];
            }
        }
        pushdown(v);
        ll ans=descent_left(r, x, v*2+1, prev); // trying to find in right child
        if(ans!=-1)return ans; // found in right child
        return descent_left(r, x, v*2, prev); // finding in left child
    }

    template<typename T>
    ll descent_right(ll l, T x){ // minimum r such that [l...r].check(x) == true, returns segtree.leng if not found
        node prev=node();
        return descent_right(l,x,1,prev);
    }
    template<typename T>
    ll descent_left(ll r, T x){ // maximum l such that [l...r].check(x) == true, returns -1 if not found
        node prev=node();
        return descent_left(r,x,1,prev);
    }
    node query(const ll &l, const ll &r){
        return query(1, l, r);
    }
    void rupd(const ll &l, const ll &r, update upd){
        rupd(1, l, r, upd);
    }
};

struct node1{
    ll sum=0;
    // use more variables if you want more information
    // these default values should be identity_element
    
    node1() {}
    node1(ll val){
        sum=val;
    }
    void merge(const node1 &l, const node1 &r){
        sum=max(l.sum,r.sum);
    }
    bool check(ll x){
        return false;
    }
}; 
struct update1{
    ll v=0;
    // use more variables if you want more information
    // these default values should be identity_transformation
    
    update1() {}
    update1(ll val){
        v=val;
    }
    // combine the current update1 with the other update1
    void combine(update1 &other, const ll &tl, const ll &tr){
        // only needed for range updates
    }
    // store the correct information in the node1 x
    void apply(node1 &x, const ll &tl, const ll &tr){
        x.sum=v;
    }
};

int connectingRopes(vector<int> &a, vector<int> &b, int n) {
    vector<pair<int,int>> ok;
    for(int i=0;i<n;i++){
        ok.push_back({a[i],b[i]});
    }
    sort(ok.begin(),ok.end());
    int mx=*max_element(a.begin(),a.end());
    mx=max(mx,*max_element(b.begin(),b.end()));
    vector<int> dp(mx+5,0);
    segTree<node1,update1> st(dp);
    for(int i=0;i<n;i++){
        st.rupd(ok[i].second,ok[i].second,st.query(0,ok[i].second-1).sum+1);
    }
    
    return st.query(0,mx+2).sum;
}
