function createAns( n){
    var poker=new Array(n);
    var rand;
    var isOK;
    for( var i=0;i<poker.length;i++){
        do{
            rand=Math.floor(Math.random()*10);
            isOK=true;
            for(var j=0;j<i;j++){
                if(poker[j]==rand){
                    isOK=false
                    break;
                }
            }//end for loop
        }while(!isOK)
        poker[i]=rand;
    }//end for loop
    var answer="";
    for(var i in poker){
        answer+=poker[i];
    }// end 
    return answer;
} //close function createAns()


function checkAB(gue,ans){                                  //將猜測的解果和答案比較
    var a=0; 
    var b=0
    for(var i=0;i<gue.length;i++){
        if(gue.charAt(i)==ans.charAt(i)){
            a++;
        }
        else if(ans.indexOf(gue.charAt(i))!=-1){
            b++
        }
    }//end for loop
    return  String(a+"A"+b+"B");
}//close function checkAB()             

var GuessNumberAns=createAns(4);
var count;
function Button_onclick(){
count++;
var GuessNumberGue= document.getElementById("text1").value;
text2.value=checkAB(GuessNumberGue,GuessNumberAns);
debug.innerHTML+=GuessNumberGue+">"+checkAB(GuessNumberGue,GuessNumberAns)+"<br>";
if(GuessNumberAns==GuessNumberGue){
    alert("You get it! You are winner. The answer is "+GuessNumberAns);
}
if(count>10){
    alert("妳真是不會猜，答案是:"+GuessNumberGue);
}
  
}//close function Button_onclick()