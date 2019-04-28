class Solution {
public:
	vector<string> findItinerary(vector<pair<string, string>> tickets) {
		unordered_map<string, multiset<string>> graph;
		vector<string> itinerary;
		if (tickets.size() == 0)  return itinerary;
		for (auto ticket : tickets){
			graph[ticket.first].insert(ticket.second);
		}
		stack<string> dfs;
		dfs.push("JFK");
		while (!dfs.empty()){
			string topAirport = dfs.top();
			if (graph[topAirport].empty()){
				itinerary.push_back(topAirport);
				dfs.pop();
			} else {
				dfs.push(*(graph[topAirport].begin()));
				graph[topAirport].erase(graph[topAirport].begin());
			}
		}
		reverse(itinerary.begin(), itinerary.end());
		return itinerary;
	}
};