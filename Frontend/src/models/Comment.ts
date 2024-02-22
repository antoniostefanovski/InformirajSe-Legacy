import { Blog } from "./Blog";
import { User } from "./User";

export class Comment {
    public id: string | undefined;

    public commentDescription: string | undefined;

    public dateComment: string = "";

    public blog?: Blog;

    public commentOwner?: User;
};