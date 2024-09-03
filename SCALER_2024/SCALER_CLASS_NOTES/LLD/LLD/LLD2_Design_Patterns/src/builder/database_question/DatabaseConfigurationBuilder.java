package builder.database_question;

public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    public static Builder getBuilder(){
        return new Builder();
    }
    DatabaseConfigurationBuilder(Builder b){
        databaseUrl = b.getDatabaseUrl();
        username = b.getUsername();
        password = b.getPassword();
        maxConnections = b.getMaxConnections();
        enableCache = b.isEnableCache();
        isReadOnly = b.isReadOnly();
    }
    public static class Builder{
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public DatabaseConfigurationBuilder build(){
            return new DatabaseConfigurationBuilder(this);
        }
        public String getDatabaseUrl() {
            return databaseUrl;
        }

        public Builder setDatabaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public String getUsername() {
            return username;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public int getMaxConnections() {
            return maxConnections;
        }

        public Builder setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public boolean isEnableCache() {
            return enableCache;
        }

        public Builder setEnableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public boolean isReadOnly() {
            return isReadOnly;
        }

        public Builder setReadOnly(boolean readOnly) {
            isReadOnly = readOnly;
            return this;
        }
    }
}
