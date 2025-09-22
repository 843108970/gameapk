package javax.mail;

public class MessageContext {
    private Part part;

    public MessageContext(Part part2) {
        this.part = part2;
    }

    private static Message getMessage(Part part2) throws MessagingException {
        while (part2 != null) {
            if (part2 instanceof Message) {
                return (Message) part2;
            }
            Multipart parent = ((BodyPart) part2).getParent();
            if (parent == null) {
                return null;
            }
            part2 = parent.getParent();
        }
        return null;
    }

    public Message getMessage() {
        try {
            return getMessage(this.part);
        } catch (MessagingException unused) {
            return null;
        }
    }

    public Part getPart() {
        return this.part;
    }

    public Session getSession() {
        Message message = getMessage();
        if (message != null) {
            return message.session;
        }
        return null;
    }
}
