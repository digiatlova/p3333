package org.example.userms.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomDataFetcherExceptionResolver extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env){
        return new GraphQLError(){
            @Override
            public String getMessage() {
                return ex.getMessage();
            }
            @Override
            public List<SourceLocation> getLocations(){
                return null;
            }
            @Override
            public ErrorClassification getErrorType(){
                return null;
            }
        };
    }
}
