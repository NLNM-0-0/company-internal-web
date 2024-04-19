package com.ciw.backend.constants;

public class Message {
	public static final String PASSWORD_VALIDATE = "Mật khẩu phải từ 6 đến 20 ký tự";
	public static final String EMAIL_VALIDATE = "Email không đúng định dạng";
	public static final String USER_NOT_LOGIN = "Xin vui lòng đăng nhập để sử dụng chức năng";
	public static final String USER_NOT_HAVE_FEATURE = "Bạn không có quyền sử dụng chức năng này";
	public static final String CAN_NOT_SEND_EMAIL = "Không thể gửi mail cho người dùng";
	public static final String TOKEN_NOT_EXIST = "Token không tồn tại. Xin vui lòng kiểm tra lại email";
	public static final String TOKEN_EXPIRED = "Token đã hết hạn. Xin vui lòng điền lại form quên mật khẩu";
	public static final String COMMON_ERR = "Đã có lỗi xảy ra. Xin hãy thử lại sau";
	public static final String JSON_ERR = "JSON không đúng định dạng";
	public static final String TIME_INVALID_FORMAT = "Thời gian cần có định dạng yyyy-MM-dd HH:mm:ss";
	public static final String IMAGE_INVALID_FORMAT = "ĐỊnh dạng ảnh không hợp lệ";
	public static class	User{
		public static final String USER_IS_DELETED = "Người dùng đã bị xóa khỏi hệ thống";
		public static final String USER_NOT_EXIST = "Người dùng không tồn tại trong hệ thống";
		public static final String NAME_VALIDATE = "Tên người dùng không được trống và tối đa 200 ký tự";
		public static final String PHONE_VALIDATE = "Số điện thoại người dùng từ 10 đến 11 chữ số";
		public static final String DOB_VALIDATE = "Ngày sinh không hợp lệ";
		public static final String ADDRESS_VALIDATE = "Địa chỉ không được để trống và có tối đa 50 ký tự";
		public static final String UNIT_VALIDATE = "Phòng ban không được để trống";
		public static final String GENDER_VALIDATE = "Giới tính người dùng không được để trống";
		public static final String NAME_FILTER_VALIDATE = "Tên người dùng không được quá 200 ký tự";
		public static final String PHONE_FILTER_VALIDATE = "Số điện thoại người dùng không được quá 11 ký tự";
		public static final String OLD_PASSWORD_NOT_CORRECT = "Mật khẩu cũ không khớp";
		public static final String CAN_NOT_DELETE_YOURSELF = "Bạn không thể xóa chính mình";
		public static final String CAN_NOT_DELETE_ADMIN = "Bạn không thể xóa tài khoản admin";
	}
	public static class	Page{
		public static final String PAGE_VALIDATE = "Số trang phải lớn hơn 0";
		public static final String PAGE_LIMIT = "Số lượng hiển thị phải lớn hơn 0";
	}
	public static class	Tag{
		public static final String TAG_NAME_INVALID = "Tên tag không được trống và tối đa 50 ký tự";
		public static final String TAG_NOT_EXIST = "Tag không tồn tại";
	}
	public static class	Post{
		public static final String POST_TITLE_VALIDATE = "Tiêu đề bài viết không được để trống và tối đa 100 ký tự";
		public static final String POST_DESCRIPTION_VALIDATE = "Mô tả bài viết không được dài hơn 200 ký tự";
		public static final String POST_CONTENT_EMPTY = "Nội dung bài viết không được để trống";
		public static final String POST_TITLE_FILTER_VALIDATE = "Tiêu đề bài viết không được quá 100 ký tự";
		public static final String POST_NOT_EXIST = "Bài viết không tồn tại";
		public static final String CAN_NOT_EDIT_OTHER_POST = "Bạn không thể chỉnh sửa bảng tin của người khác";
	}
	public static class	Unit{
		public static final String UNIT_NAME_VALIDATE = "Tên phòng ban không được để trống và tối đa 100 ký tự";
		public static final String UNIT_NAME_FILTER_VALIDATE = "Tên phòng ban không được quá 100 ký tự";
		public static final String UNIT_NOT_EXIST = "Phòng ban không tồn tại";
	}
	public static class	Feature{
		public static final String FEATURE_NOT_EXIST = "Chức năng không tồn tại";
	}
	public static class File {
		public static final String FILE_UPLOAD_FAIL = "Đã có lỗi xảy ra đối với việc upload file. Xin hãy thử lại sau";
		public static final String FILE_INVALID_FORMAT = "File không đúng định dạng. Xin hãy thử file khác";
	}
	public static class Auth{
		public static final String USER_NOT_CORRECT = "Email hoặc mật khẩu chưa đúng. Xin hãy thử lại";
	}
}