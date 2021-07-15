package apiConfig;

import java.util.HashMap;
import java.util.Map;

public class QueryParams {

	//query params
	public Map<String, Integer> defaultqueryParams(int id){
		Map<String, Integer> queryparam = new HashMap<String, Integer>();
		queryparam.put("userId", id);
		
		return queryparam;

	}

	public Map<String, Integer> queryParamsPostID(int postID){
		Map<String, Integer> queryparam = new HashMap<String, Integer>();
		queryparam.put("postId", postID);

		return queryparam;

	}
	
	public Map<String, String> SearchQueryParam(String searchName)
	{
		
		Map<String, String> query =  new HashMap<String, String>();
		query.put("s", searchName);
		return query;
	}

}
