public enum State {
    Unvisited, Visited, Visiting;
}

public static boolean search(Graph g, Node start, Node end) {
    List<Node> q = new LinkedList<Node>();
    for (Node u : g.getNodes()) {
        u.state = State.Unvisited;
    }
    start.state = State.Visiting;
    q.add(start);
    Node u;
    while (!q.isEmpty()) {
        u = q.removeFirst(); // dequeue
        if (u != null) {
            for (Node v : u.getAdjcent()) {
                if (v.state == State.Unvisited) {
                    if (v == end) return true;
                    else {
                        v.state = State.Visiting;
                        q.add(v);
                    }
                }
            }
            u.state = State.Visited;
        }
    }
    return false;
}
