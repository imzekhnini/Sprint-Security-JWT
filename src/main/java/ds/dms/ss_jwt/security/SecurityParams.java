package ds.dms.ss_jwt.security;

/**
 * SecurityParams
 */
public interface SecurityParams {
  public static final String JWT_HEADER_NAME = "Authorization";
  public static final String SECRET = "mySecretKey123";
  public static final long EXPIRATION = 10 * 24 * 3600;
  public static final String HEADER_PREFIX = "Bearer ";
}
