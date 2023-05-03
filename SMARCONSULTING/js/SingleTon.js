var SingleTon = function(obj){
		var __instance;
	return {
		getInstance:function(){
			if (__instance==null) {
				__instance = new obj();
			}
			return __instance;
		}
	};
}