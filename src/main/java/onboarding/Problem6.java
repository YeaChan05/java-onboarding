package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        HashSet<String> emails = new HashSet<>();
        Map<String, String> hashMap = new HashMap<>();

        String name;
        String email;
        String keyword;

        for (int i=0;i< forms.size();i++) {
            name = forms.get(i).get(1);//닉네임

            for(int j=0; j<name.length()-1;j++)//문자 하나씩
            {
                keyword = name.substring(j,j+2);//두글자씩 자르기
                if(hashMap.containsKey(keyword)){
                    email = hashMap.get(keyword);
                    if(!email.equals(forms.get(i).get(0))){
                        emails.add(email);//email 중복 아니면 추가
                        emails.add(forms.get(i).get(0));
                    }
                }
                hashMap.put(keyword,forms.get(i).get(0));
            }
        }
        answer = emails.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.print(answer);
        return answer;
    }
}