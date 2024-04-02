function solution(n, lost, reserve) {
    var answer = 0;
    lost.sort()
    reserve.sort()

    // 잃어버린 사람과 여분 있는 사람이 같은 경우 필터
    let l = lost.filter((v)=>{
        return !reserve.includes(v)
    })
    let r = reserve.filter((v)=>{
       return !lost.includes(v);
    });


    const a = l.filter((v)=>{
        let extra = r.find((rr)=>{//빌려줄 수 있는 경우
            return Math.abs(v-rr) <=1;
        });
        if(!extra) return true; // 빌려줄수 없는 경우 a에 추가
        r = r.filter((q)=>q!==extra) // r배열 업데이트
    })
    
    answer = n-a.length //전체 - 못빌린 사람의 수 
    return answer;
}