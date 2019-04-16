HessianSerializerEnhanced

Little library which main purpose is to fix problems with serialization / deserialization of specific Java types using Hessian library. These objects have missing or broken serialization / deserialization or suffer from lack of functionality.

Supported Java types:
- BigDecimal
- LocalDate
- LocalTime
- LocalDateTime

Other types will be added on demand.

Which problems are fixed?

- https://stackoverflow.com/questions/11247239/bigdecimal-value-is-always-zero-when-transfered-with-spring-remoting-via-hessian
- https://stackoverflow.com/questions/44133470/hessian-serialization-and-deserialization-of-java-time-year
- https://jira.apache.org/jira/browse/CAY-2038
- ...
