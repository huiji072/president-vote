//package com.example.presidentvote.repository;
//
//import com.example.presidentvote.domain.Member;
//import org.springframework.jdbc.datasource.DataSourceUtils;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class JdbcMemberRepository implements MemberRepository{
//
//    private final DataSource dataSource;
//    public JdbcMemberRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    @Override
//    public Member save(Member member) {
//        String sql = "insert into member(id, password, name, RRN, number) values(?, ?, ?, ?, ?)";
//        //String sql = "insert into member(id, password, name, RRN, number) values('aa', 'aaa', 'aaaa', '2342', '465')";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            conn = getConnection();
//           //pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, member.getId());
//            pstmt.setString(2, member.getPassword());
//            pstmt.setString(3, member.getName());
//            pstmt.setLong(4, member.getRRN());
//            pstmt.setLong(5, member.getNumber());
//
//
//
//            pstmt.executeUpdate();
//           // rs = pstmt.getGeneratedKeys();
//            rs = pstmt.executeQuery();
//
////            if (rs.next()) {
////                member.setId(rs.getString(1));
////            } else {
////                throw new SQLException("id 조회 실패");
////            }
//
//            return member;
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public Optional<Member> findById(String id) {
//        String sql = "select * from member where id = ?";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        System.out.println("~~~id : " + id);
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, id);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                Member member = new Member();
//                member.setId(rs.getString("id"));
//                return Optional.of(member);
//            } else {
//                return Optional.empty();
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public Optional<Member> findByPassword(String password) {
//        String sql = "select * from member where password = ?";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        System.out.println("~~~password : " + password);
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(2, password);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                Member member = new Member();
//                member.setPassword(rs.getString("password"));
//                return Optional.of(member);
//            } else {
//                return Optional.empty();
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public List<Member> findAll() {
//        String sql = "select * from member";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//            List<Member> members = new ArrayList<>();
//            while(rs.next()) {
//                Member member = new Member();
//                member.setId(rs.getString("id"));
//                member.setPassword(rs.getString("password"));
//                member.setName(rs.getString("name"));
//
//                member.setRRN(rs.getLong("RRN"));
//                member.setNumber(rs.getLong("number"));
//                members.add(member);
//            }
//            return members;
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        String sql = "select * from member where name = ?";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        System.out.println("~~~name : " + name);
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(3, name);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                Member member = new Member();
//                member.setName(rs.getString("name"));
//                return Optional.of(member);
//            }
//            return Optional.empty();
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public Optional<Member> findByNumber(Long number) {
//        String sql = "select * from member where number = ?";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        System.out.println("~~~number : " + number);
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//           pstmt.setLong(5, number);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                Member member = new Member();
//                member.setNumber(rs.getLong("number"));
//                return Optional.of(member);
//            } else {
//                return Optional.empty();
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public Optional<Member> findByRRN(Long RRN) {
//        String sql = "select * from member where RRN = ?";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        System.out.println("~~~RRN : " + RRN);
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setLong(4, RRN);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                Member member = new Member();
//                member.setRRN(rs.getLong("RRN"));
//                return Optional.of(member);
//            } else {
//                return Optional.empty();
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    private Connection getConnection() {
//        return DataSourceUtils.getConnection(dataSource);
//    }
//    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
//    {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (pstmt != null) {
//                pstmt.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (conn != null) {
//                close(conn);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private void close(Connection conn) throws SQLException {
//        DataSourceUtils.releaseConnection(conn, dataSource);
//    }
//}
