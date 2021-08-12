package View.Notice;
import View.UI.UI_2;
import Vo.Notice.NoticeVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class NoticeMain extends UI_2 implements ActionListener{

    int willBeShown = 0;
    int numberOfNotices = 0;
    int i = -1;
    boolean shouldBeRemoved = false;

    JPanel centerPane = new JPanel();
    String titles[];
    String sequences[];
    String selectedTitle = "";
    NoticeVO theOne;
    //	HashMap<Integer, NoticeVO> theHashOne = new HashMap<Integer, NoticeVO>();
    List<NoticeVO> notices;

    JButton southBar_prevBtn;
    JButton southBar_nextBtn;
    JTextField southBar_search;

    public NoticeMain() {
        init();
        centerPane.setLayout(new FlowLayout());
        print10Notices();
    }

    // 공지사항 세팅
    public void print10Notices() {
        // (처음에만, 즉 i가 -1일때만)보여줄 내용을 셋팅
        if(i == -1) {
            NoticeDAO dao = new NoticeDAO();
            notices = dao.setAllNotices();
            titles = new String[notices.size()];
            sequences = new String[notices.size()];
        }
        // 반복문용 이터레이터
        Iterator<NoticeVO> noticesIterator1 = notices.iterator();
        Iterator<NoticeVO> noticesIterator2 = notices.iterator();
        // 빈 칸
        JPanel spacePane = new JPanel();
        spacePane.setPreferredSize(new Dimension(800, 32));
        centerPane.add(spacePane);

        // 공지사항 제목 세팅
        JPanel northBar = new JPanel();
        northBar.setPreferredSize(new Dimension(800, 40));
        northBar.setLayout(new FlowLayout());
        northBar.setBackground(new Color(108, 92, 231));
        JLabel northBar_noLbl = new JLabel("번호");
        JLabel northBar_titleLbl = new JLabel("제목");
        northBar.add(northBar_noLbl);
        northBar_noLbl.setHorizontalAlignment(JLabel.CENTER);
        northBar_noLbl.setPreferredSize(new Dimension(60, 32));
        northBar.add(northBar_titleLbl);
        northBar_titleLbl.setHorizontalAlignment(JLabel.CENTER);
        northBar_titleLbl.setPreferredSize(new Dimension(520, 32));

        // 버튼 만들고
        JButton addBtn = new JButton("추가");
        JButton updateBtn = new JButton("수정");
        JButton deleteBtn = new JButton("삭제");
        addBtn.setPreferredSize(new Dimension(60, 32));
        updateBtn.setPreferredSize(new Dimension(60, 32));
        deleteBtn.setPreferredSize(new Dimension(60, 32));
        addBtn.setBackground(new Color(108, 92, 231));
        updateBtn.setBackground(new Color(108, 92, 231));
        deleteBtn.setBackground(new Color(108, 92, 231));
        addBtn.setBorderPainted(false);
        updateBtn.setBorderPainted(false);
        deleteBtn.setBorderPainted(false);

        // 배치
        northBar.add(addBtn);
        northBar.add(updateBtn);
        northBar.add(deleteBtn);

        // 버튼에 이벤트 설정
        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        centerPane.add(northBar);
        // 공지사항 하나하나 세팅(최대 10개) > ★★★ 제안: 조회/수정/삭제버튼 각각 만들지 말고 타이틀바에 하나만 만드는건?

        // (처음에만, 즉 i가 -1일때만)보여줄 내용을 셋팅
        if(i == -1) {
            while(noticesIterator1.hasNext()) {
                // 하나의 VO에 대해 공지사항 정보를 빼 옴
                NoticeVO oneNotice = noticesIterator1.next();
                // 걔를 타이틀과
                titles[numberOfNotices] = oneNotice.getTitle();
                // 시퀀스에 다시 담음 => 이거 필요한가?
                sequences[numberOfNotices] = String.valueOf(oneNotice.getCode());
                // 라벨용 패널 만들고 시퀀스, 타이틀 표시
                if(numberOfNotices < notices.size()-1) {
                    numberOfNotices++;
                } else {
                    i = 0;
                    break;
                }
            }
        }

        while(noticesIterator2.hasNext()) {
//			System.out.println(i + "번째 친구는: " + titles[i]);
            // 공지사항용 가로로 길쭉한 패널 배치
            JPanel noticePane = new JPanel();
            noticePane.setPreferredSize(new Dimension(800, 40));
            // 레이아웃 바꿔야 이쁘게 배치될것
            noticePane.setLayout(new FlowLayout());
            // 색깔 적당한거 찾아서 바꿔야 됨
            if (willBeShown % 2 == 0) {
                noticePane.setBackground(new Color(199, 236, 238));
            } else {
                noticePane.setBackground(new Color(189, 195, 199));
            }

            JLabel sequenceLabel = new JLabel(sequences[i]);

            // 라벨 배치
            sequenceLabel.setHorizontalAlignment(JLabel.CENTER);
            sequenceLabel.setPreferredSize(new Dimension(60, 32));
            noticePane.add(sequenceLabel);

            // 걍 버튼으로 만들기
            JButton titleBtn = new JButton(titles[i]);
            titleBtn.setBorderPainted(false);
            titleBtn.setPreferredSize(new Dimension(720, 32));
            titleBtn.setHorizontalAlignment(JButton.LEFT);
            if (willBeShown % 2 == 0) {
                titleBtn.setBackground(new Color(199, 236, 238));
            } else {
                titleBtn.setBackground(new Color(189, 195, 199));
            }

            titleBtn.addActionListener(this);

            // 패널에 세팅
            noticePane.add(titleBtn);
            centerPane.add(noticePane);
            // 추후 이동 버튼 누르면 i에 10을 더해줄 것
            if(willBeShown % 10 == 9) {
//				System.out.println(willBeShown);
                willBeShown = 0;
                break;
            } else {
                // willBeShown이
//				System.out.println(willBeShown);
                // 한 페이지에 10개만 보여줄거니까 i로 세기
                willBeShown++;
            }
            if(i < numberOfNotices) {
                i++;
            } else {
                break;
            }
        }
//		System.out.println("이 시점에서의 i는" + i);
        // 공백 만들기
        JPanel spacePaneSouth = new JPanel();
        spacePaneSouth.setPreferredSize(new Dimension(800, 32));
        centerPane.add(spacePaneSouth);

        // 페이지 이동/검색 창
        JPanel southBar = new JPanel();
        southBar.setLayout(new FlowLayout());
        southBar_prevBtn = new JButton("◀");
        southBar_prevBtn.setPreferredSize(new Dimension(60, 32));
        southBar_search = new JTextField(20);
        southBar_search.setPreferredSize(new Dimension(60, 32));
        JButton southBar_searchBtn = new JButton("검색");
        southBar_searchBtn.setPreferredSize(new Dimension(60, 32));
        southBar_nextBtn = new JButton("▶");
        southBar_nextBtn.setEnabled(true);
        southBar_nextBtn.setPreferredSize(new Dimension(60, 32));
        southBar.add(southBar_prevBtn);
        southBar.add(southBar_search);
        southBar.add(southBar_searchBtn);
        southBar.add(southBar_nextBtn);
        southBar_prevBtn.addActionListener(this);
        southBar_searchBtn.addActionListener(this);
        southBar_nextBtn.addActionListener(this);

        centerPane.add(southBar);

        add(centerPane);
    }

    // 버튼 클릭 이벤트
    @Override
    public void actionPerformed(ActionEvent a) {
        String btnLbl = a.getActionCommand();
        NoticeDAO dao = new NoticeDAO();
        if(btnLbl.equals("추가")) {
            addNotice(dao);
        } else if(btnLbl.equals("수정")) {
            updateNotice(dao);
        } else if(btnLbl.equals("삭제")) {
            removeNotice(dao);
        } else if(btnLbl.equals("◀")) {
            selectedTitle = "";
            if (i % 10 != 9) {
                i -= numberOfNotices % 10 + 10;
            } else {
                i -= 19;
            }
            if (i <= 0) {
                i = 0;
            }
            willBeShown = 0;
            reset10Notices();
//		} else if(btnLbl.equals("검색")) {
//			if(!(southBar_search.getText().isEmpty())) {
//				searchNotice();
//			} else {
//				JOptionPane.showMessageDialog(this, "검색어를 입력하십시오");
//			}
        } else if(btnLbl.equals("▶")) {
            selectedTitle = "";
            if(i < numberOfNotices - (numberOfNotices % 10)) {
                i++;
            } else if(i == numberOfNotices) {
                i = numberOfNotices - (numberOfNotices % 10);
                willBeShown = 0;
            }
            reset10Notices();
        } else {
            // 클릭된 친구 변수에
            selectedTitle = btnLbl;
            selectNotice();
        }
    }

    // 마우스로 게시물 선택
    public NoticeVO selectNotice() {
//		System.out.println("여기 왜 안오니? " + selectedTitle);
        int wantedSequence = 0;
        int index = 0;
        NoticeDAO dao = new NoticeDAO();
        // 공지사항 데이터가 담긴 NoticeVO를 모음
        notices = dao.setAllNotices();
        // 반복문용 이터레이터
        Iterator<NoticeVO> noticesIterator = notices.iterator();
        while(noticesIterator.hasNext()) {
            // 하나의 VO에서 공지사항 정보를 빼 옴
            System.out.println(index);
            NoticeVO oneNotice = noticesIterator.next();
            System.out.println("공지사항 타이틀 " + oneNotice.getTitle());
            if(oneNotice.getTitle().equals(selectedTitle)) {
                wantedSequence = oneNotice.getCode();
                System.out.println("wantedSequence: " + wantedSequence);
                // 나와서
                System.out.println("break 직전의 인덱스: "+ index);
                break;
            } else {
                System.out.println("반복문이 끝날 때 여기는 안오지 않나?: "+ index);
                index++;
            }
//			} else {
//				System.out.println("ㅋㅋㅋ여기오겠지?");
        }
        // 선택된 데이터(공지사항 한개)
        // 해시맵이었다가 리스트로 바꿔서 이걸 못쓰게 됐다...
//		theOne = notices.get(wantedSequence);

        // 결국 얘가 문제다.
        if(selectedTitle=="") {
            // ◀, ▶버튼일 때
            index = 0;
        } else if (shouldBeRemoved) {
            // 삭제버튼일 때
            System.out.println("wantedSequence 야매용: " + wantedSequence);
            index--;
        }
        System.out.println("인덱스" + index);
        System.out.println("사이즈" + notices.size());
        System.out.println("selectedTitle" + selectedTitle);
        theOne = notices.get(index);
        System.out.println("The one I really want: " + index);
        return theOne;
    }

    public void addNotice(NoticeDAO dao) {
        NoticeDetail newBoard = new NoticeDetail();
        newBoard.setFrame();
    }

    // 수정
    public void updateNotice(NoticeDAO dao) {
        dao.showOldRecord(theOne);
    }


    // 얘만 잘 수정하고
    // ★★★★★ 삭제시 > 이동하고 삭제하면 잘 삭제되거나 이상한 번호가 삭제되는데 바로 삭제하면 Index 17 out of bounds
    public void removeNotice(NoticeDAO dao) {
        shouldBeRemoved = true;
        int question = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
        if(question == JOptionPane.YES_OPTION) {
            int cnt = dao.removeRecord(theOne);
            System.out.println("설마 여기도 못오나요?");
            if(cnt == 1) {
                reset10Notices();
                JOptionPane.showMessageDialog(this, "삭제해 버렸지 뭐야!");
            } else {
                JOptionPane.showMessageDialog(this, "삭제 실패ㅜㅜ");
            }
        }
    }

    public void reset10Notices() {
        centerPane.setVisible(false);
        centerPane.removeAll();
        centerPane.setVisible(true);
        selectNotice();
        System.out.println("셀렉은 되지?");
        print10Notices();
    }

    // 검색만 잘 추가하면 된다
    public void searchNotice() {
        String keyword = southBar_search.getText();
        System.out.println("키워드는 " + keyword);
        NoticeDAO dao = new NoticeDAO();
        notices = dao.searchRecords(keyword);
        if( notices.size() < 11 ) {
            titles = new String[10];
            sequences = new String[10];
        } else {
            titles = new String[notices.size()];
            sequences = new String[notices.size()];
        }
        i = 0;
        willBeShown = 0;
        System.out.println("검색 메소드에서는 나오니? " + selectedTitle);
        reset10Notices();
    }


    //실행용 메인
    public static void main(String[] args) {
        new NoticeMain();
    }

}
