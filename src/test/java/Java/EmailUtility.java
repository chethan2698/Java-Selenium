/*
 * package Java;
 * 
 * import java.io.File; import java.io.FileReader; import
 * java.nio.charset.StandardCharsets; import java.util.*;
 * 
 * import javax.activation.DataHandler; import javax.activation.FileDataSource;
 * import javax.mail.*; import javax.mail.internet.*;
 * 
 * import org.json.simple.JSONObject; import org.json.simple.parser.JSONParser;
 * 
 * 
 * public class EmailUtility {
 * 
 * public static void sendMail() {
 * 
 * final String senderEmail = "noreply-test@stryker.com"; final String
 * senderPassword = ""; final String recipientEmail = "baban.kadke@stryker.com";
 * 
 * Properties props = new Properties();
 * 
 * props.put("mail.smtp.host", "smtp.office365.com"); props.put("mail.debug",
 * "true"); props.put("mail.smtp.auth", "false");
 * props.put("mail.smtp.starttls.enable", "true"); props.put("mail.smtp.port",
 * "587");
 * 
 * 
 * Session session = Session.getInstance(props, new javax.mail.Authenticator() {
 * protected PasswordAuthentication getPasswordAuthentication() { return new
 * PasswordAuthentication(senderEmail, senderPassword); } });
 * 
 * try { Message message = new MimeMessage(session); message.setFrom(new
 * InternetAddress(senderEmail));
 * message.setRecipients(Message.RecipientType.TO,
 * InternetAddress.parse(recipientEmail));
 * message.setSubject("Testing JavaMail API");
 * message.setText("This is a test email sent from Java.");
 * 
 * Transport.send(message);
 * 
 * System.out.println("Email sent successfully!"); } catch (MessagingException
 * e) { e.printStackTrace(); } }
 * 
 * public static void sendMailWithAttachment(String ToAddress,String
 * CcAddress,String filepath) {
 * 
 * try { Properties properties = new Properties(); JSONParser parser = new
 * JSONParser(); String
 * jsonConfig=System.getProperty("user.dir")+"/email/sendemail.json"; final
 * JSONObject config = (JSONObject) parser.parse(new FileReader(jsonConfig));
 * 
 * Map<String, String> sendemailserverdata = (Map<String, String>)
 * config.get("emailserverdata"); Iterator it =
 * sendemailserverdata.entrySet().iterator(); while (it.hasNext()) { Map.Entry
 * pair = (Map.Entry)it.next();
 * 
 * if(!pair.getKey().toString().isBlank()&&!pair.getValue().toString().isBlank()
 * ) { //******* To append build number in the session name on browserstack
 * properties.put(pair.getKey().toString(), pair.getValue().toString()); }
 * 
 * }
 * 
 * StringBuilder stringBuilder = new StringBuilder();
 * stringBuilder.append("<html>"); stringBuilder.append("<body>");
 * 
 * stringBuilder.append("<head>"); stringBuilder.append("<style>");
 * stringBuilder.append("th {background-color: #0F71AD;}");
 * stringBuilder.append("</style>"); stringBuilder.append("</head>");
 * 
 * stringBuilder.append("<p>Hi All,</p>");
 * //stringBuilder.append("<p>Greetings of the Day !</p>");
 * stringBuilder.append("<p>Testing the Mail by Java Code, please ignore.</p>");
 * stringBuilder.append("<p>Thanks,</p>");
 * stringBuilder.append("<p>Chethan A T</p>"); stringBuilder.append("</body>");
 * stringBuilder.append("</html>");
 * 
 * // Create a new Session instance Object data = config.get("username");
 * Session session = Session.getInstance(properties, new Authenticator() {
 * 
 * @Override protected PasswordAuthentication getPasswordAuthentication() {
 * return new PasswordAuthentication((String)config.get("username"),
 * decrypt((String)config.get("password"))); } });
 * 
 * 
 * // Create a new MimeMessage Message message = new MimeMessage(session);
 * message.setFrom(new InternetAddress((String)config.get("username")));
 * 
 * // Set the To recipient message.setRecipients(Message.RecipientType.TO,
 * InternetAddress.parse(ToAddress));
 * 
 * // Set the CC recipient message.setRecipients(Message.RecipientType.CC,
 * InternetAddress.parse(CcAddress));
 * 
 * // Set the BCC recipient //message.setRecipients(Message.RecipientType.BCC,
 * InternetAddress.parse(recipientBCC));
 * 
 * message.setSubject("Java Mail Test"); // Set the email subject
 * 
 * // Create the multipart message Multipart multipart = new MimeMultipart();
 * 
 * // Create the message body part BodyPart messageBodyPart = new
 * MimeBodyPart();
 * 
 * messageBodyPart.setText(stringBuilder.toString());
 * messageBodyPart.setContent(stringBuilder.toString(),
 * "text/html; charset=utf-8"); multipart.addBodyPart(messageBodyPart);
 * 
 * 
 * messageBodyPart = new MimeBodyPart(); FileDataSource source = new
 * FileDataSource(filepath); messageBodyPart.setDataHandler(new
 * DataHandler(source)); messageBodyPart.setFileName(source.getName());
 * multipart.addBodyPart(messageBodyPart); message.setContent(multipart);
 * 
 * // Save the message as a draft Transport.send(message);
 * 
 * 
 * System.out.println("Email sent successfully."); } catch (MessagingException
 * e) { e.printStackTrace(); System.err.println("Failed to send the email."); }
 * catch(Exception e) { e.printStackTrace(); } } public static void draftMail()
 * { final String email = "chethan.at@stryker.com"; final String password =
 * "U21hcnRANDIyNzIj";
 * 
 * // Mail properties Properties props = new Properties();
 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.starttls.enable",
 * "false"); props.put("mail.smtp.host", "syksmtp.stryker.com");
 * props.put("mail.smtp.port", "25");
 * 
 * // Create a mail session Session session = Session.getInstance(props, new
 * javax.mail.Authenticator() { protected PasswordAuthentication
 * getPasswordAuthentication() { return new PasswordAuthentication(email,
 * decrypt(password)); } });
 * 
 * try { // Create a new email message Message message = new
 * MimeMessage(session); message.setFrom(new InternetAddress(email));
 * message.setRecipients(Message.RecipientType.TO,
 * InternetAddress.parse("chethan.at@stryker.com"));
 * message.setRecipients(Message.RecipientType.CC,
 * InternetAddress.parse("harshitha.ul@stryker.com"));
 * message.setSubject("Draft email subject");
 * message.setText("This is a draft email message.");
 * 
 * // Set message flags to mark it as a draft Flags flags = new
 * Flags(Flags.Flag.DRAFT); message.setFlags(flags, true);
 * 
 * // Save the message as a draft Transport.send(message);
 * 
 * System.out.println("Draft email saved successfully.");
 * 
 * } catch (MessagingException e) { throw new RuntimeException(e); }
 * 
 * } public static void readMail() { final String email =
 * "chethan.at@stryker.com"; final String password = "U21hcnRANDIyNzIj";
 * 
 * // IMAP properties Properties props = new Properties();
 * props.setProperty("mail.imap.auth", "true");
 * props.setProperty("mail.store.protocol", "imaps");
 * props.setProperty("mail.imap.ssl.enable", "false");
 * props.setProperty("mail.imap.host", "sykimap.stryker.com");
 * props.setProperty("mail.imap.port","25");
 * 
 * try { // Get session //Session session = Session.getInstance(props);
 * 
 * // Connect to the store
 * 
 * //store.connect(email, password); Session session =
 * Session.getInstance(props, new Authenticator() {
 * 
 * @Override protected PasswordAuthentication getPasswordAuthentication() {
 * return new PasswordAuthentication(email, decrypt(password)); } }); Store
 * store = session.getStore("imaps");
 * 
 * // Get inbox folder Folder inbox = store.getFolder("INBOX");
 * inbox.open(Folder.READ_ONLY);
 * 
 * // Fetch messages Message[] messages = inbox.getMessages();
 * 
 * // Print messages for (Message message : messages) {
 * System.out.println("Subject: " + message.getSubject());
 * System.out.println("From: " + message.getFrom()[0]);
 * System.out.println("Body: " + message.getContent().toString());
 * System.out.println("-------------------------------------"); }
 * 
 * // Close store and folder inbox.close(false); store.close(); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * } public static String encrypt(String plainPassword) { return
 * java.util.Base64.getEncoder().encodeToString(plainPassword.getBytes(
 * StandardCharsets.UTF_8)); }
 * 
 * public static String decrypt(String encryptedPassword) { byte[] decoded =
 * java.util.Base64.getDecoder().decode(encryptedPassword); return new
 * String(decoded, StandardCharsets.UTF_8); }
 * 
 * private static String getTextFromMessage(Message message) throws Exception {
 * if (message.isMimeType("text/plain")) return message.getContent().toString();
 * else if (message.isMimeType("multipart/*")) { MimeMultipart mimeMultipart =
 * (MimeMultipart) message.getContent(); return
 * getTextFromMimeMultipart(mimeMultipart); } return ""; }
 * 
 * private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart)
 * throws Exception { int count = mimeMultipart.getCount(); if (count == 0)
 * return ""; boolean multipartAlternative = new
 * ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
 * if (multipartAlternative) { // Return only the first body part return
 * getTextFromBodyPart((BodyPart) mimeMultipart.getBodyPart(0)); } StringBuilder
 * result = new StringBuilder(); for (int i = 0; i < count; i++) { BodyPart
 * bodyPart = mimeMultipart.getBodyPart(i);
 * result.append(getTextFromBodyPart(bodyPart)); } return result.toString(); }
 * 
 * private static String getTextFromBodyPart(BodyPart bodyPart) throws Exception
 * { if (bodyPart.isMimeType("text/plain")) return (String)
 * bodyPart.getContent(); else if (bodyPart.isMimeType("text/html")) return
 * (String) bodyPart.getContent(); else if (bodyPart.getContent() instanceof
 * MimeMultipart) return getTextFromMimeMultipart((MimeMultipart)
 * bodyPart.getContent()); return ""; }
 * 
 * public static void main(String[] args) {
 * 
 * System.out.println(encrypt("Chethu@26"));//Q2hldGh1QDI2
 * System.out.println(decrypt("Q2hldGh1QDI2")); //sendMail();
 * //sendMailWithAttachment(); //readMail(); //draftMail(); }
 * 
 * }
 */