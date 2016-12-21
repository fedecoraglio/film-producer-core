package com.film.producer.core.model.exception;

public class ActorException extends RuntimeException {

    private final ActorExceptionType type;

    public ActorException(final ActorExceptionType type, Throwable t) {
        super(t);
        this.type = type;
    }

    public ActorException(final ActorExceptionType type) {
        this(type, null);
    }

    public enum ActorExceptionType {
        ACTOR_NOT_FOUND("actor.not.found"),
        FIRST_NAME_EMPTY("create.actor.first.name.empty"),
        LAST_NAME_EMPTY("create.actor.last.name.empty");

        private final String prefixKey;

        ActorExceptionType(final String prefixKey) {
            this.prefixKey = prefixKey;
        }

        public String getCode() {
            return prefixKey + ".code";
        }

        public String getDescription() {
            return prefixKey + ".description";
        }
    }

    public ActorExceptionType getType() {
        return type;
    }
}
