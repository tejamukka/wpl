import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CriticalPaths {
	Graph dag;
	int crit;
    LinkedList<Vertex> cpath = new LinkedList<>();
    CriticalPaths(Graph g) {
    	dag =g;
    }

    
    void findCriticalPaths() {
    	List <Vertex> li=getTopological(dag);
   // 	System.out.println(li.get(0));
    	li.get(0).ec=0;
    	for(Vertex v:li){
    		for(Edge e: v.adj){
    			e.otherEnd(v) .ec = Math.max(e.otherEnd(v).ec, v.ec+ e.otherEnd(v).d);
    		}
    	}
    	
    	
    	
    	LinkedList<Vertex> l2 = getTopologicalOrder(dag);
    	Vertex t=l2.getFirst();
    	t.lc=t.ec;
    	
    	for(Vertex u : l2){
    		u.lc=t.lc;
    		//System.out.println("in l2" + u);
    	}
    	for(Vertex v:l2){
    		for(Edge e:v.revAdj){
    			e.otherEnd(v).lc =Math.min(e.otherEnd(v).lc, v.lc-v.d);
    			e.otherEnd(v).slack=e.otherEnd(v).lc-e.otherEnd(v).ec;
    			if(e.otherEnd(v).slack==0){
    				e.otherEnd(v).isCritical=true;
    			}
    		}
    	}
    	
    	for(Vertex v:dag){
    		if(v.ec == v.lc){
    			crit+=v.d;}
    		for(Edge e:v.adj){
    		/*	if(e.otherEnd(v).lc==e.otherEnd(v).ec){
    				e.otherEnd(v).p=v;
    			}*/
    			if(( e.to.isCritical  && e.from.isCritical) && v.lc + e.to.d==e.to.lc){
    				 e.isTight = true;
    				
    			}
    		}
    		
    	}
    	for(Vertex v:li){
    		
    		for(Edge e:v.adj){
    			/*if(v.p!=null && v.seen==true){
    				cpath.add(v);
    				v.seen=false;
    				if(e.otherEnd(v).p!=null && v.seen!=true){
    					cpath.add(e.otherEnd(v));
    					e.otherEnd(v).seen=false;
    				}
    				
    			}*/
    			if(e.isTight){
    				/*cpath.add(e.from);
    				cpath.add(e.to);*/
    				cpath.add(e.otherEnd(v));
    			//	System.out.println();
    			}
    		}
    	}
    	
    	showOutput(cpath,dag)	;
    }
    
    public void showOutput(LinkedList<Vertex> cpath, Graph dag){
    System.out.println(crit);
    for(Vertex v: cpath){
		System.out.print(" "+ v);
	}
    System.out.println();
    System.out.println("TaskNumber    EarliestCompletion      LatestCompletion     Slack");
    for(Vertex v:dag){  
    	System.out.println(v+ "            "+"               " + v.ec+"                "+v.lc+"             " +v.slack);
    }
    }
    
    public static void computeN(Graph dag){
    	for(Vertex u : dag){
    		u.n=0;
    	}
    	
    	List <Vertex> li=getTopological(dag);
    	 Vertex s = li.get(0);
    		s.n=1;
    for(Vertex v:li){
    	for(Edge e:v.adj){
    		e.to.n +=v.n;
    	}
    }
    }
    
    public static LinkedList<Vertex> getTopologicalOrder(Graph dag) {
		LinkedList<Vertex> list = new LinkedList<>();
		// initialize 
		for(Vertex u : dag.v) {
			if( u != null ) {
				u.seen = false;
				u.topological = false;
			}
		}
		// Run DFS visit
		for(Vertex u : dag.v) {
			if(u != null && !u.seen) {
				try {
					DFSVisit(u, list);
				} catch (Exception e) {
					return null;
				}
			}
		}
		return list;
	}
	/**
	 *  DFS Visit
	 * @param u
	 * @throws Exception
	 */
	private static void DFSVisit(Vertex u, LinkedList<Vertex> list) throws Exception {
		u.seen = true;
		u.topological = true;
		Vertex v = null;
		for(Edge e : u.adj) {
			v = e.otherEnd(u);
			if(!v.seen) {
				DFSVisit(v, list);
			} else if(v.topological) {
				throw new Exception("Graph has cycle");
			}
		}
		
		list.add(u);
		u.topological = false;
	}
	
	public static List<Vertex> getTopological(Graph dag) {
		List<Vertex> topolist = new LinkedList<Vertex>();
		
		Queue<Vertex> q = new LinkedList<>();
		int count=0;
		for(Vertex v: dag){
			if(v.indegree==0)
				q.add(v);
		}
		Vertex u = null;
		while(!q.isEmpty()){
			u=q.remove();
			topolist.add(u);
			++count;
			for(Edge e:u.adj){
				e.otherEnd(u).indegree--;
				if(e.otherEnd(u).indegree==0){
					q.add(e.otherEnd(u));
				}
			}
			
		}
		if(count!=dag.size){
			System.out.println("Graph is not a DAG");
			return null;
		}
		
		return topolist;
		
		
	}
	
	
	
}
