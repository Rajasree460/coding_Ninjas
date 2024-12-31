import java.util.ArrayList;

 

public class Solution {

    public static ArrayList<Integer> findCacheValue(ArrayList<ArrayList<Integer>> arr, int m, int n) {

        // Write your code here.

        ArrayList<Integer> ans = new ArrayList<>();

        int sz = 0;

 

        ArrayList<Integer> cache = new ArrayList<>();

        for(int i=0;i<n;i++) {

            cache.add(-1);

        } 

 

        ArrayList<CacheEntry> cacheEntries = new ArrayList<>();

        for(int i=0;i<n;i++) {

            cacheEntries.add(new CacheEntry(0, 0, 0));

        }

 

        for(int i=0;i<m;i++) {

            int operation = arr.get(i).get(0);

 

            if(operation == 1) {

                int check = 0;

                int key = arr.get(i).get(1);

                int value = arr.get(i).get(2);

 

                for(int j=0;j<n;j++) {

                    if(cache.get(j) == key){

                        cacheEntries.get(j).frequncy++;

                        cacheEntries.get(j).lastAccess = i;

                        cacheEntries.get(j).value = value;

                        check = 1;

                        break;

                    }

                }

 

                if(check == 1) {

                    continue;

                }

 

                if(sz < n) {

                    cache.set(sz, key);

                    cacheEntries.set(sz, new CacheEntry(1, i, value));

                    sz++;

                }else {

                    int pos = 0;

 

                    for(int j=1;j<n;j++) {

                        CacheEntry entryPos = cacheEntries.get(pos);

                        CacheEntry entryJ = cacheEntries.get(j);

 

                        if(entryJ.frequncy < entryPos.frequncy) {

                            pos = j;

                        }else if(entryJ.frequncy == entryPos.frequncy && entryJ.lastAccess < entryPos.lastAccess) {

                            pos = j;

                        }

                    }

                    cache.set(pos, key);

                    cacheEntries.set(pos, new CacheEntry(1, i, value));

                }

            }else {

                int key = arr.get(i).get(1);

                int value = -1;

 

                for(int j=0;j<n;j++) {

                    if(cache.get(j) == key) {

                        value = cacheEntries.get(j).value;

                        break;

                    }

                }

                ans.add(value);

            }

        }

        return ans;

        

    }

    static class CacheEntry {

        int frequncy;

        int lastAccess;

        int value;

 

        CacheEntry(int frequncy, int lastAccess,int value) {

            this.frequncy = frequncy;

            this.lastAccess = lastAccess;

            this.value = value;

        }

    }

}
