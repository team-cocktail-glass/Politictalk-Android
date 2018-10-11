package politictalk.dsm.Report;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import politictalk.dsm.Meeting.MeetingMainActivity;
import politictalk.dsm.R;

public class SearchActivity extends AppCompatActivity {

    private List<String> list;
    private ListView listView;
    private EditText editSearch;
    private SearchAdapter adapter;
    private ArrayList<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editSearch = (EditText)findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);

        list = new ArrayList<String>();
        settingList();

        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        adapter = new SearchAdapter(list, this);
        listView.setAdapter(adapter);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editSearch.getText().toString();
                search(text);
            }
        });
    }

    public void search(String charText) {
        list.clear();
        if(charText.length()==0) {
            list.addAll(arraylist);
        } else {
            for(int i = 0; i<arraylist.size(); i++) {
                if(arraylist.get(i).toLowerCase().contains(charText)) {
                    list.add(arraylist.get(i));
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void settingList() {
        list.add("서울특별시 강남구");
        list.add("서울특별시 강동구");
        list.add("서울특별시 강북구");
        list.add("서울특별시 강서구");
        list.add("서울특별시 관악구");
        list.add("서울특별시 광진구");
        list.add("서울특별시 구로구");
        list.add("서울특별시 금천구");
        list.add("서울특별시 노원구");
        list.add("서울특별시 도봉구");
        list.add("서울특별시 동대문구");
        list.add("서울특별시 동작구");
        list.add("서울특별시 마포구");
        list.add("서울특별시 서대문구");
        list.add("서울특별시 서초구");
        list.add("서울특별시 성동구");
        list.add("서울특별시 성북구");
        list.add("서울특별시 송파구");
        list.add("서울특별시 양천구");
        list.add("서울특별시 영등포구");
        list.add("서울특별시 용산구");
        list.add("서울특별시 은평구");
        list.add("서울특별시 종로구");
        list.add("서울특별시 중구");
        list.add("서울특별시 중랑구");
        list.add("부산광역시 중구");
        list.add("부산광역시 서구");
        list.add("부산광역시 동구");
        list.add("부산광역시 영도구");
        list.add("부산광역시 부산진구");
        list.add("부산광역시 동래구");
        list.add("부산광역시 남구");
        list.add("부산광역시 북구");
        list.add("부산광역시 해운대구");
        list.add("부산광역시 기장군");
        list.add("부산광역시 사하구");
        list.add("부산광역시 금정구");
        list.add("부산광역시 강서구");
        list.add("부산광역시 중연제구");
        list.add("부산광역시 수영구");
        list.add("부산광역시 사상구");
        list.add("대구광역시 중구");
        list.add("대구광역시 동구");
        list.add("대구광역시 서구");
        list.add("대구광역시 남구");
        list.add("대구광역시 북구");
        list.add("대구광역시 수성구");
        list.add("대구광역시 달서구");
        list.add("대구광역시 달성군");
        list.add("인천광역시 중구");
        list.add("인천광역시 동구");
        list.add("인천광역시 미추홀구");
        list.add("인천광역시 연수구");
        list.add("인천광역시 남동구");
        list.add("인천광역시 부평구");
        list.add("인천광역시 계양구");
        list.add("인천광역시 서구");
        list.add("인천광역시 강화군");
        list.add("인천광역시 옹진군");
        list.add("광주광역시 동구");
        list.add("광주광역시 서구");
        list.add("광주광역시 남구");
        list.add("광주광역시 북구");
        list.add("광주광역시 광산구");
        list.add("대전광역시 동구");
        list.add("대전광역시 중구");
        list.add("대전광역시 서구");
        list.add("대전광역시 유성구");
        list.add("대전광역시 대덕구");
        list.add("울산광역시 중구");
        list.add("울산광역시 남구");
        list.add("울산광역시 동구");
        list.add("울산광역시 북구");
        list.add("울산광역시 울주군");
        list.add("세종특별자치시");
        list.add("수원시장안구");
        list.add("수원시권선구");
        list.add("수원시팔달구");
        list.add("수원시영통구");
        list.add("성남시수정구");
        list.add("성남시중원구");
        list.add("성남시분당구");
        list.add("의정부시");
        list.add("안양시동안구");
        list.add("부천시");
        list.add("광명시");
        list.add("평택시");
        list.add("양주시");
        list.add("동두천시");
        list.add("안산시상록구");
        list.add("안산시단원구");
        list.add("고양시덕양구");
        list.add("고양시일산동구");
        list.add("과천시");
        list.add("의왕시");
        list.add("구리시");
        list.add("남양주시");
        list.add("오산시");
        list.add("화성시");
        list.add("시흥시");
        list.add("군포시");
        list.add("하남시");
        list.add("파주시");
        list.add("여주시");
        list.add("이천시");
        list.add("용인시처인구");
        list.add("용인시수지구");
        list.add("용인시기흥구");
        list.add("안성시");
        list.add("김포시");
        list.add("광주시");
        list.add("포천시");
        list.add("연천군");
        list.add("양평군");
        list.add("가평군");
        list.add("춘천시");
        list.add("원주시");
        list.add("강릉시");
        list.add("동해시");
        list.add("삼척시");
        list.add("태백시");
        list.add("정선군");
        list.add("속초시");
        list.add("고성군");
        list.add("양양군");
        list.add("인제군");
        list.add("홍천군");
        list.add("횡성군");
        list.add("영월군");
        list.add("평창군");
        list.add("화천군");
        list.add("양구군");
        list.add("철원군");
        list.add("청주시상당구");
        list.add("청주시서원구");
        list.add("청주시흥덕구");
        list.add("청주시청원구");
        list.add("충주시");
        list.add("제천시");
        list.add("단양군");
        list.add("영동군");
        list.add("보은군");
        list.add("옥천군");
        list.add("음성군");
        list.add("진천군");
        list.add("괴산군");
        list.add("증평군");
        list.add("천안시서북구");
        list.add("천안시동남구");
        list.add("공주시");
        list.add("보령시");
        list.add("아산시");
        list.add("서산시");
        list.add("태안군");
        list.add("금산군");
        list.add("논산시");
    }
}

