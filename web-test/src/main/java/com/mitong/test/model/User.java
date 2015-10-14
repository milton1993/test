package com.mitong.test.model;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/2
 */
public class User {
    private String username;
    private String password;
    private boolean isAdmin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.isAdmin = builder.isAdmin;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder{
        private String username;
        private String password;
        private boolean isAdmin;

        public Builder buildUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder buildIsadmin(int isAdmin) {
            this.isAdmin = (isAdmin == 1);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
